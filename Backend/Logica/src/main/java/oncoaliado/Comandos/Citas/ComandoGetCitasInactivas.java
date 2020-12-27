package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import entidades.Cita;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoGetCitasInactivas extends ComandoBase {

    private List<Cita> citas = null;
    private long idMedicoEspecialidad;

    /**
     * Constructor de la clase.
     * @param id Objeto de tipo long con el id del médico.
     * @throws Excepciones "El id del médico debe ser mayor o igual a 0." en caso de que el id sea inválido.
     */
    public ComandoGetCitasInactivas(long id) throws Excepciones {
        try {
            if (id <= 0) {
                throw new Excepciones("El id del médico debe ser mayor o igual a 0.");
            }else {
                this.idMedicoEspecialidad = id;
            }
        }catch (Excepciones e) {
            throw e;
        }catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de buscar las citas del médico pedido.
     * @see DaoCita Data access object usado para buscar las citas.
     * @throws Excepciones "No existencitas inactivas para este médico." en caso de no haber citas inactivas
     * para el médico en cuestión registrada en la base de datos.
     */
    @Override
    public void execute() throws Excepciones {
        try {
            DaoCita daoCita = DaoFactory.DaoCitaInstancia();
            this.citas = daoCita.getCitasInactivas(idMedicoEspecialidad);
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método que retorna el resultado de las citas encontradas.
     * @return Lista de objetos tipo Cita.
     * @see Cita
     * @throws Excepciones
     */
    @Override
    public List<Cita> getResult() throws Excepciones {
        try {
            execute();
            return this.citas;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
