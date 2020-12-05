package accesos.Daos;

import javax.persistence.EntityManager;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Pais;

public class DaoPais extends Dao<Pais> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPais() {
        super( _handler );
    }

}