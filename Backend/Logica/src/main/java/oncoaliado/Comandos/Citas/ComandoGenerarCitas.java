package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoEspecialidaMedico;
import entidades.Cita;
import entidades.EspecialidadMedico;
import entidades.FactoryEntidades;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoGenerarCitas;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoGenerarCitas extends ComandoBase {

    private List<Cita> citas = null;
    private List<DtoGenerarCitas> dtoGenerarCitas;
    private long medEspId;

    /**
     * Constructor de la clase.
     * @since 25/12/2020
     * @param id Objeto de tipo long con el id del médico (no del usuario).
     * @param dtoGenerarCitas Objeto d tipo DtoGenerarCitas con los datos para crear las citas pedidas.
     * @see DtoGenerarCitas Data transfer object usado para obtener los datos necesarios para la creación de citas.
     */
    public ComandoGenerarCitas(long id, List<DtoGenerarCitas> dtoGenerarCitas) throws Excepciones {
        try{
            for (DtoGenerarCitas obj: dtoGenerarCitas) {
                if(obj.getCantCitas() <= 0) {
                    throw new Excepciones("Un objeto dentro de la lista de objetosD DtoGenerarCitas no tiene " +
                            "cantidad de citas.");
                }else if(obj.getFecha() == null) {
                    throw new Excepciones("Un objeto dentro de la lista de objetosD DtoGenerarCitas no tiene " +
                            "fecha.");
                }else if(obj.getDuracion() <= 0) {
                    throw new Excepciones("Un objeto dentro de la lista de objetosD DtoGenerarCitas tiene " +
                            "duración de las citas menor o igual a 0.");
                }
            }
            if(id <= 0) {
                throw new Excepciones("Id del médico inválido, debe ser mayor a 0.");
            }
            this.dtoGenerarCitas = dtoGenerarCitas;
            this.medEspId = id;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de generar las citas y registrarlas en la base de datos.
     * @since 25/12/2020
     * @see DaoCita Data access object usado para insertar las citas generadas.
     * @see DaoEspecialidaMedico Data access object usado para buscar entidad objeto EspecialidadMedico en la base de datos.
     * @see EspecialidadMedico Entidad persistente usada para guardar el objeto buscado con el DAO anterior mencionado.
     */
    @Override
    public void execute() throws Excepciones {
        try {
            DaoEspecialidaMedico daoEspecialidadMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
            DaoCita daoCita = DaoFactory.DaoCitaInstancia();
            EspecialidadMedico especialidadMedico = daoEspecialidadMedico.find(this.medEspId, EspecialidadMedico.class);
            if(especialidadMedico == null) {
                throw new Excepciones("La especialidad médico especificada no encontrada.");
            }
            for (DtoGenerarCitas obj1: this.dtoGenerarCitas) {
                GregorianCalendar horaProxima = obj1.getFecha();
                int duracion = obj1.getDuracion();
                int cantCitas = obj1.getCantCitas();

                for(int i = 0; i < cantCitas; i++) {
                    Cita cita = FactoryEntidades.CitaInstancia();

                    cita.setFecha(horaProxima);
                    cita.setEstatus("inactiva");
                    cita.setMedico(especialidadMedico);
                    cita.setPaciente(null);
                    cita.setTipoCita(null);
                    cita.setDescripcion(null);
                    cita.setFactura(null);
                    cita.setMedicoDiagnostico(null);

                    cita = daoCita.insert(cita);
                    if(cita.getId() == 0) {
                        throw new Excepciones("Cita no insertada de manera correcta.");
                    }
                    horaProxima.add(GregorianCalendar.MINUTE, duracion);
                }
            }
            this.citas = daoCita.findAll(Cita.class);
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de retornar las citas
     * @since 25/12/2020
     * @return lista con todas las citas incluyendo las recién insertadas.
     * @throws Excepciones
     */
    @Override
    public List<Cita> getResult() throws Excepciones {
        try{
            execute();
            return this.citas;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }
}
