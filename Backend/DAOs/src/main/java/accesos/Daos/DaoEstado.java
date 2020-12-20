package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Estado;
import entidades.Pais;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoEstado extends Dao<Estado> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEstado() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public List<Estado> getEstados(Pais pais) {
        try{
            TypedQuery<Estado> estados = this._em.createNamedQuery("GetEstadosByPais", Estado.class);
            estados.setParameter("pais", pais).getResultList();

            List<Estado> resultado = estados.getResultList();
            return resultado;
        }catch (Exception e){
            return null;
        }
    }

}