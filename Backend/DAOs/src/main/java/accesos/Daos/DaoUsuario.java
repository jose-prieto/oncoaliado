package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoUsuario extends Dao<Usuario> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoUsuario() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public Usuario verificaUsuario(String pass, String correo) {
        try {
            TypedQuery<Usuario> usuario = this._em.createNamedQuery("verificarPass", Usuario.class);
            usuario.setParameter("contrasena", pass).setParameter("correo", correo).getSingleResult();

            Usuario resultado = usuario.getSingleResult();
            return resultado;
        } catch(Exception ex) {
            return null;
        }
    }

}
