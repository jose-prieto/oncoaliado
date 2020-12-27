package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Usuario;
import excepciones.Excepciones;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoUsuario extends Dao<Usuario> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoUsuario() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public Usuario verificaUsuario(String pass, String correo) throws Excepciones {
        try {
            if (pass == null) {
                throw new Excepciones("El campo password debe estar lleno.");
            }else if (correo == null) {
                throw new Excepciones("El campo correo debe estar lleno.");
            }
            TypedQuery<Usuario> usuario = this._em.createNamedQuery("verificarPass", Usuario.class);

            return usuario.setParameter("contrasena", pass).setParameter("correo", correo).getSingleResult();
        }catch (Excepciones e) {
            throw e;
        }catch (Exception e) {
            if(e.getMessage().equals("getSingleResult() did not retrieve any entities.")) {
                throw new Excepciones("Correo y/o contraseña no coinciden con ningún usuario registrado.");
            } else {
                throw e;
            }
        }
    }

}
