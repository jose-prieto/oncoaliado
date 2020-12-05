package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Paciente;

import javax.persistence.EntityManager;

public class DaoPaciente extends Dao<Paciente> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPaciente() {
        super( _handler );
    }

}
