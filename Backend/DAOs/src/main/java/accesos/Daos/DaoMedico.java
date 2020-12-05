package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Medico;

import javax.persistence.EntityManager;

public class DaoMedico extends Dao<Medico> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoMedico() {
        super( _handler );
    }

}
