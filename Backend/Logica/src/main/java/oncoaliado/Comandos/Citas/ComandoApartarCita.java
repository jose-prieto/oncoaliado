package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoFactura;
import accesos.Daos.DaoPaciente;
import accesos.Daos.DaoTipoCita;
import entidades.*;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoApartarCita extends ComandoBase {

    private final long idPaciente;
    private final long idCita;
    private final long idTipoCita;
    private Factura factura = FactoryEntidades.FacturaInstancia();
    private Cita cita = FactoryEntidades.CitaInstancia();

    /**
     * Constructor de la clase.
     * @since 25/12/2020
     * @param idCita Objeto de tipo long con el id de la cita.
     * @param idPaciente Objeto de tipo long con el id del paciente (no del usuario).
     * @param idTipoCita Objeto de tipo long con el id del TipoCita.
     * @throws Excepciones en caso de que algún id no sea válido.
     */
    public ComandoApartarCita(long idCita, long idPaciente, long idTipoCita) throws Excepciones {
        if (idCita <= 0) {
            throw new Excepciones("El id de la cita debe ser mayor a 0.");
        }else if(idPaciente <= 0) {
            throw new Excepciones("El id del paciente debe ser mayor a 0.");
        }else if(idTipoCita <= 0) {
            throw new Excepciones("El id del Tipo de la cita debe ser mayor a 0.");
        }else{
            this.idCita = idCita;
            this.idTipoCita = idTipoCita;
            this.idPaciente = idPaciente;
        }
    }

    /**
     * Método utilizado para crear la factura correspondiente para próximo pago de la cita médica
     * @since 27/12/2020
     * @return Objeto de tipo factura.
     * @see Factura Entidad persistente utilizada para retornar los datos de la factura creada.
     * @see DaoFactura Data access object creado para insertar la factura en el sistema.
     */
    public void crearFactura() throws Excepciones {
        DaoFactura daoFactura = DaoFactory.DaoFacturaInstancia();
        this.factura = FactoryEntidades.FacturaInstancia();
        this.factura.setEstatus("pendiente");
        this.factura.setTotal(this.cita.getPrecio());
        this.factura = daoFactura.insert(this.factura);
        if(this.factura.getId() == 0) {
            throw new Excepciones("La factura no se ha creado de manera correcta.");
        }
    }

    /**
     * Método encargado de asignar a un cliente a alguna cita disponible, cambia su estado a pendiente y le asigna un tipo de cita.
     * @since 26/12/2020
     * @see DaoCita Data access object usado para buscar la cita en cuestión y su precio.
     * @see DaoPaciente Data access object usado para buscar al paciente en cuestión.
     * @see DaoTipoCita Data access object usado para buscar el tipo de cita especificado.
     * @see Paciente Entidad persistente usada para almacenar al paciente buscado.
     * @see TipoCita Entidad persistente usada para almacenar al tipo de cita especificado.
     * @throws Excepciones En caso de que alguno de los datos no se encuentre en la base de datos.
     */
    @Override
    public void execute() throws Excepciones {
        Paciente paciente;
        DaoCita daoCita = DaoFactory.DaoCitaInstancia();
        this.cita = daoCita.find(this.idCita, Cita.class);
        if(this.cita == null) {
            throw new Excepciones("Cita especificada no encontrada.");
        }else if(!this.cita.getEstatus().equals("inactiva")) {
            throw new Excepciones("Cita ya reservada por otro paciente.");
        }
        DaoTipoCita daoTipoCita = DaoFactory.DaoTipoCitaInstancia();
        TipoCita tipoCita = daoTipoCita.find(this.idTipoCita, TipoCita.class);
        if(tipoCita == null) {
            throw new Excepciones("Tipo de cita especificada no encontrada.");
        }
        this.cita.setTipoCita(tipoCita);
        this.cita.setPrecio(daoCita.getPrecio(this.idTipoCita));
        crearFactura();
        this.cita.setFactura(this.factura);
        DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
        paciente = daoPaciente.find(this.idPaciente, Paciente.class);
        if(paciente == null) {
            throw new Excepciones("Paciente especificado no encontrado.");
        }
        this.cita.setPaciente(paciente);
        this.cita.setEstatus("pendiente");
        this.cita = daoCita.update(this.cita);
    }

    /**
     * Método encargado de retornar la cita actualizada con los nuevos datos asignados.
     * @since 26/12/2020
     * @return Objeto de tipo Cita.
     * @see Cita Entidad persistente usada para almacenar la cita actualizada.
     * @throws Excepciones Retorna excepciones tomadas en metodos usados anteriormente.
     */
    @Override
    public Cita getResult() throws Excepciones {
        execute();
        return this.cita;
    }

}
