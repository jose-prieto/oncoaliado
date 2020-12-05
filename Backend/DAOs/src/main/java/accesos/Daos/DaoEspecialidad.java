package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Especialidad;

import javax.persistence.EntityManager;

public class DaoEspecialidad  extends Dao<Especialidad> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEspecialidad() {
        super( _handler );
    }

}
