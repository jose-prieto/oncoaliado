package oncoaliado.Comandos.Ingresos;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoTipoUsuario;
import accesos.Daos.DaoUsuario;
import entidades.Estado;
import entidades.FactoryEntidades;
import entidades.TipoUsuario;
import entidades.Usuario;
import excepciones.Excepciones;
import transfer.DtoUsuario;

/**
 * @author José Prieto
 * @version 1.0
 */
public class AddUsuario {
    private Usuario usuario = FactoryEntidades.UsuarioInstancia();

    /**
     * Método usado para ingresar el usuario del médico o del paciente al sistema
     * @param dtoUsuario Data transfer object usado para obtener los datos del usuario.
     * @return Objeto de tipo Usuario.
     * @see Usuario Entidad persistente usada para retornar el usuario agregado al sistema.
     * @throws Excepciones Lanza excepciones en caso de que alguno de los datos sea inválido o no esté presente.
     */
    public Usuario addUsuario(DtoUsuario dtoUsuario) throws Excepciones {
        if (dtoUsuario.getCorreo() == null) {
            throw new Excepciones("El campo correo debe estar lleno.");
        }else if (dtoUsuario.getContrasena() == null) {
            throw new Excepciones("El campo contraseña debe estar lleno.");
        } else if (dtoUsuario.getNombre1() == null) {
            throw new Excepciones("El campo nombre 1 debe estar lleno.");
        } else if (dtoUsuario.getApellido1() == null) {
            throw new Excepciones("El campo apellido 1 debe estar lleno.");
        } else if (dtoUsuario.getFechaNac() == null) {
            throw new Excepciones("El campo de fecha debe estar lleno");
        } else if (dtoUsuario.getGenero() == null) {
            throw new Excepciones("El campo genero debe estar lleno");
        } else if (!dtoUsuario.getGenero().equals("mas") && !dtoUsuario.getGenero().equals("fem")) {
            throw new Excepciones("Las posibles opciones para el campo genero son 'fem' o 'mas'.");
        } else if (dtoUsuario.getDireccion() == null) {
            throw new Excepciones("El campo de direccion debe estar lleno.");
        } else if (dtoUsuario.getEstado() == null) {
            throw new Excepciones("El campo de estado debe estar lleno.");
        } else if (dtoUsuario.getTipoUsuario() == null) {
            throw new Excepciones("El campo de tipo usuario debe estar lleno.");
        } else {
            this.usuario.setEstatus("a");
            this.usuario.setCorreo(dtoUsuario.getCorreo());
            Decodificación decoFront = new Decodificación(dtoUsuario.getContrasena());
            Decodificación decoBack = new Decodificación(decoFront.decodeFront());
            this.usuario.setContrasena(decoBack.encodeBack());
            this.usuario.setNombre1(dtoUsuario.getNombre1());
            this.usuario.setNombre2(dtoUsuario.getNombre2());
            this.usuario.setApellido1(dtoUsuario.getApellido1());
            this.usuario.setApellido2(dtoUsuario.getApellido2());
            this.usuario.setFechaNac(dtoUsuario.getFechaNac());
            this.usuario.setGenero(dtoUsuario.getGenero());
            this.usuario.setDireccion(dtoUsuario.getDireccion());
        }

        DaoEstado daoEstado = DaoFactory.DaoEstadoInstancia();
        Estado estado = daoEstado.find(dtoUsuario.getEstado().getId(), Estado.class);
        DaoTipoUsuario daoTipoUsuario = DaoFactory.DaoTipoUsuarioInstancia();
        TipoUsuario tipoUsuario = daoTipoUsuario.find(dtoUsuario.getTipoUsuario().getId(), TipoUsuario.class);
        if (estado == null) {
            throw new Excepciones("El estado no fue encontrado.");
        } else if (tipoUsuario == null) {
            throw new Excepciones("El tipo usuario especificado no ha sido encontrado.");
        } else {
            this.usuario.setEstado(estado);
            this.usuario.setTipoUsuario(tipoUsuario);
        }
        DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();
        this.usuario = daoUsuario.insert(this.usuario);

        if (this.usuario.getId() == 0) {
            throw new Excepciones("El usuario no se ha agregado de manera correcta");
        }
        return this.usuario;
    }

}
