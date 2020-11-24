package ucab.dsw.accesodatos;

import ucab.dsw.entidades.TipoPregunta;
import javax.persistence.EntityManager;

public class DaoTipoPregunta extends Dao<TipoPregunta> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTipoPregunta( )
    {
        super( _handler );
    }

}