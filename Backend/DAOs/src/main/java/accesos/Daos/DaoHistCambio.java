package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.HistCambio;

import javax.persistence.EntityManager;

public class DaoHistCambio extends Dao<HistCambio> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoHistCambio() {
        super( _handler );
    }

}
