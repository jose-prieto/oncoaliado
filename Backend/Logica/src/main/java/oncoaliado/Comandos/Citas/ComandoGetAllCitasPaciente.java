package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoPaciente;
import entidades.Cita;
import entidades.Paciente;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoGetAllCitasPaciente extends ComandoBase {

    private List<Cita> citas;
    private long id;

    /**
     * Constructor de la clase
     * @since 25/12/2020
     * @param id Objeto de tipo long con el id del paciente (no del usuario).
     */
    public ComandoGetAllCitasPaciente(long id) {
        this.id = id;
    }

    /**
     * Método encargado de buscar todas las citas registradas del paciente en cuestión
     * @since 25/12/2020
     * @see DaoPaciente Data access object usado para buscar al paciente solicitado.
     * @see DaoCita Data access object usado para buscar todas las citas del paciente.
     * @throws Exception En caso de que el id del paciente no se encuentre registrado o que no tenga citas registradas.
     */
    @Override
    public void execute() throws Excepciones {
        try{
            DaoCita dao = DaoFactory.DaoCitaInstancia();
            DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
            Paciente paciente = daoPaciente.find(this.id, Paciente.class);
            if(paciente == null) {
                throw new Excepciones("Paciente solicitado no registrado en la base de datos.");
            }else{
                this.citas = dao.getCitasPaciente(paciente);
            }
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de retornar todas las citas encontradas en la base de datos asignadas al paciente en cuestión.
     * @return Lista de objetos de tipo Cita.
     * @see Cita Entidad persistente usada para retornar las citas solicitadas.
     * @throws Excepciones
     */
    @Override
    public List<Cita> getResult() throws Excepciones {
        try {
            execute();
            return this.citas;
        }catch(Excepciones e){
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
