package accesos;

import entidades.PAIS;

import javax.persistence.EntityManager;

public class DaoPais extends Dao<PAIS>
{

    private EntityManager _em;
    static DaoHandler _handler;

    static {
        try {
            _handler = new DaoHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DaoPais() { super( _handler ); }

}