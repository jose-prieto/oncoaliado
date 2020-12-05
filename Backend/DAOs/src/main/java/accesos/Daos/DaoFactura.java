package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Factura;

import javax.persistence.EntityManager;

public class DaoFactura  extends Dao<Factura> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoFactura() {
        super( _handler );
    }

}
