package accesos.Daos;

import javax.persistence.EntityManager;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Evento;

public class DaoEvento extends Dao<Evento> {

    static DaoHandler _handler = new DaoHandler();

    public DaoEvento() {
        super( _handler );
    }

}