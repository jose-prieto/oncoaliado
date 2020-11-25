package accesos;

import javax.persistence.EntityManager;
import entidades.Pais;

public class DaoPais extends Dao<Pais>
{

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPais() {
        super( _handler );
    }

}