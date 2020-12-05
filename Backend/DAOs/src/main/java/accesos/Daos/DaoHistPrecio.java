package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.HistPrecio;

import javax.persistence.EntityManager;

public class DaoHistPrecio extends Dao<HistPrecio> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoHistPrecio() {
        super( _handler );
    }

}
