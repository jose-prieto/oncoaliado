package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.HistPrecio;
import entidades.TipoCita;
import excepciones.Excepciones;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class DaoHistPrecio extends Dao<HistPrecio> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoHistPrecio() {
        super( _handler );
        this._em = _handler.getSession();
    }
}
