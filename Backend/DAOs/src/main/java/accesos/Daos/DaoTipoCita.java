package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.TipoCita;
import excepciones.Excepciones;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;

public class DaoTipoCita extends Dao<TipoCita> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoTipoCita() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public BigDecimal getPrecio(TipoCita tipoCita) throws Excepciones {
        try {
            if(tipoCita == null) {
                throw new Excepciones("El tipo de cita no debe ser null.");
            }
            TypedQuery<BigDecimal> precio = this._em.createNamedQuery("getPrecio", BigDecimal.class);
            return precio.setParameter("tipoCita", tipoCita).getSingleResult();
        }catch(Exception e) {
            throw e;
        }finally {
            this._em.clear();
        }
    }
}
