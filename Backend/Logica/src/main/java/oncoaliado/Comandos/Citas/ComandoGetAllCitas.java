package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import entidades.Cita;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

/**
 * @version 1.0
 * @author José Prieto
 */
public class ComandoGetAllCitas extends ComandoBase {

    private List<Cita> citas = null;

    /**
     * Método que busca todas las citas registradas en la base de datos.
     * @since 25/12/2020
     * @see DaoCita Data access object usado.
     */
    @Override
    public void execute() {
        DaoCita daoCita = DaoFactory.DaoCitaInstancia();
        this.citas = daoCita.findAll(Cita.class);
    }

    /**
     * Método que retorna todas las citas encontradas en el sistema en caso de haber.
     * @since 25/12/2020
     * @return Lista de objetos de tipo Cita.
     * @see Cita Entidad persistente citas usado.
     */
    @Override
    public List<Cita> getResult(){
        execute();
        return this.citas;
    }

}
