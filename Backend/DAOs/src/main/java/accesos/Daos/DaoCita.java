package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Cita;

import javax.persistence.EntityManager;

public class DaoCita extends Dao<Cita> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoCita() {
        super( _handler );
    }

}
