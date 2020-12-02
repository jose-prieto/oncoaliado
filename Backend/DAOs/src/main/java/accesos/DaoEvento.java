package accesos;

import javax.persistence.EntityManager;

import entidades.Evento;

public class DaoEvento extends Dao<Evento>
{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEvento() {
        super( _handler );
    }

}