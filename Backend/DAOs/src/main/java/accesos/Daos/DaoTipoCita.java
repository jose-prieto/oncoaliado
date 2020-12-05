package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.TipoCita;

import javax.persistence.EntityManager;

public class DaoTipoCita extends Dao<TipoCita> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTipoCita() {
        super( _handler );
    }

}
