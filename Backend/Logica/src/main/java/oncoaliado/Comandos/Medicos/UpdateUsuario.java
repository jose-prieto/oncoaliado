package oncoaliado.Comandos.Medicos;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoUsuario;
import entidades.Estado;
import entidades.Usuario;
import excepciones.Excepciones;
import oncoaliado.Comandos.Ingresos.Decodificación;
import transfer.DtoUsuario;

public class UpdateUsuario {

    private final DtoUsuario dtoUsuario;

    public UpdateUsuario(DtoUsuario dtoUsuario) throws Excepciones {
        if(dtoUsuario.getId() <= 0) {
            throw new Excepciones("El id del usuario debe ser mayor a 0.");
        }else {
            this.dtoUsuario = dtoUsuario;
        }
    }

    public void updateUsuario() throws Excepciones {
        DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();
        Usuario usuario = daoUsuario.find(this.dtoUsuario.getId(), Usuario.class);
        if(usuario == null) {
            throw new Excepciones("Usuario no encontrado en la base de datos.");
        }
        if (this.dtoUsuario.getEstatus() != null) {
            if (!this.dtoUsuario.getEstatus().equals("a") && !this.dtoUsuario.getEstatus().equals("i")) {
                throw new Excepciones("El estado del usuario debe ser 'a' o 'i'.");
            } else {
                usuario.setEstatus(this.dtoUsuario.getEstatus());
            }
        }
        if (this.dtoUsuario.getCorreo() != null) {
            usuario.setCorreo(this.dtoUsuario.getCorreo());
        }
        if (this.dtoUsuario.getContrasena() != null) {
            Decodificación decoFront = new Decodificación(this.dtoUsuario.getContrasena());
            Decodificación encoBack = new Decodificación(decoFront.decodeFront());
            usuario.setContrasena(encoBack.encodeBack());
        }
        if (this.dtoUsuario.getNombre1() != null) {
            usuario.setNombre1(this.dtoUsuario.getNombre1());
        }
        if (this.dtoUsuario.getNombre2() != null) {
            usuario.setNombre2(this.dtoUsuario.getNombre2());
        }
        if (this.dtoUsuario.getApellido1() != null) {
            usuario.setApellido1(this.dtoUsuario.getApellido1());
        }
        if (this.dtoUsuario.getApellido2() != null) {
            usuario.setApellido2(this.dtoUsuario.getApellido2());
        }
        if (this.dtoUsuario.getFechaNac() != null) {
            usuario.setFechaNac(this.dtoUsuario.getFechaNac());
        }
        if (this.dtoUsuario.getGenero() != null) {
            if (!this.dtoUsuario.getGenero().equals("fem") && !this.dtoUsuario.getGenero().equals("mas")) {
                throw new Excepciones("El género del usuario debe ser 'fem' o 'mas'");
            } else {
                usuario.setGenero(this.dtoUsuario.getGenero());
            }
        }
        if (this.dtoUsuario.getFoto() != null) {
            usuario.setFoto(this.dtoUsuario.getFoto());
        }
        if (this.dtoUsuario.getDireccion() != null) {
            usuario.setDireccion(this.dtoUsuario.getDireccion());
        }
        if (this.dtoUsuario.getEstado() != null) {
            DaoEstado daoEstado = DaoFactory.DaoEstadoInstancia();
            Estado estado = daoEstado.find(dtoUsuario.getEstado().getId(), Estado.class);
            usuario.setEstado(estado);
        }
        daoUsuario.update(usuario);
    }
}
