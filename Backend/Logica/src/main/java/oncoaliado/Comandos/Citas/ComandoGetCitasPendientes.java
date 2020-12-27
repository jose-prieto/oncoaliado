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
public class ComandoGetCitasPendientes extends ComandoBase {

    private List<Cita> citas = null;

    /**
     * constructor de la clase.
     * @since 25/12/2020
     */
    public ComandoGetCitasPendientes() {

    }

    /**
     * Método encargado de buscar todas las citas en estado "pendiente" registradas en la base de datos.
     * @since 25/12/2020
     * @see DaoCita Data access object usado para buscar las citas registradas.
     * @throws Excepciones "No hay citas en estado pendiente en estos momentos." en caso de no haber del estado mencionado
     * registradas en la base de datos.
     */
    @Override
    public void execute() {
        try{
            DaoCita daoCita = DaoFactory.DaoCitaInstancia();
            this.citas = daoCita.getCitasPendientes();
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de retornar todas las citas en estado "pendiente" encontradas en la base de datos.
     * @since 25/12/2020
     * @return Lista de objetos del tipo Cita.
     * @see Cita Entidad persistente usada para retornar los valores
     * @throws Excepciones
     */
    @Override
    public List<Cita> getResult() {
        try{
            execute();
            return this.citas;
        }catch(Exception e) {
            throw e;
        }
    }

}
