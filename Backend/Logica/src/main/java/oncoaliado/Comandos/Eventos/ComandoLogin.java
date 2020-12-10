package oncoaliado.Comandos.Eventos;

import accesos.DaoFactory;
import accesos.Daos.DaoEvento;
import accesos.Daos.DaoUsuario;
import entidades.Evento;
import entidades.Usuario;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoLogin extends ComandoBase {

    private Usuario usuario;
    private String pass;
    private String user;

    public ComandoLogin(String pass, String user) {

        this.pass = pass;
        this.user = user;

    }

    @Override
    public void execute() {
        try {
            DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();
            List<Usuario> usuarios;
            usuarios = daoUsuario.findAll(Usuario.class);
            for (Usuario obj: usuarios) {
                if(obj.getContrasena().equals(user) && obj.getContrasena().equals(pass)) {
                    this.usuario = obj;
                    this.usuario.setContrasena(null);
                    break;
                }
            }
        } catch(Exception ex) {
            String prueba = ex.getMessage();
        }
    }

    @Override
    public Usuario getResult(){
        return this.usuario;
    }

}
