package accesos.Daos;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Evento;
import excepciones.Excepciones;

import java.util.List;

public class DaoEvento extends Dao<Evento> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEvento() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public List<Evento> eventosInactivos() {
        try {
            TypedQuery<Evento> eventos = this._em.createNamedQuery("eventosInactivos", Evento.class);
            return eventos.setParameter("estatus", "a").getResultList();
        }catch(Exception e) {
            throw e;
        }finally {
            this._em.clear();
        }
    }
}