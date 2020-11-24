package ucab.dsw.accesodatos;

import javax.persistence.EntityManager;
import ucab.dsw.entidades.Pais;

public class DaoPais extends Dao<Pais>
{

    private EntityManager _em;
    static DaoHandler _handler;

    public DaoPais() {
        super( _handler );
    }

}