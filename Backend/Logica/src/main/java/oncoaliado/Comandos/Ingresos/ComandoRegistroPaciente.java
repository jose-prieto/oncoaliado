package oncoaliado.Comandos.Ingresos;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoPaciente;
import accesos.Daos.DaoTipoUsuario;
import accesos.Daos.DaoUsuario;
import entidades.*;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoPaciente;

public class ComandoRegistroPaciente extends ComandoBase {

    private Paciente paciente = FactoryEntidades.PacienteInstancia();
    private Usuario usuario = FactoryEntidades.UsuarioInstancia();

    public ComandoRegistroPaciente(DtoPaciente paciente) {
        try {
            Decodificación decoFront = new Decodificación(paciente.getUsuario().getContrasena());
            Decodificación decoBack = new Decodificación(decoFront.decodeFront());

            this.usuario.setEstatus(paciente.getUsuario().getEstatus());
            this.usuario.setCorreo(paciente.getUsuario().getCorreo());
            this.usuario.setContrasena(decoBack.encodeBack());
            this.usuario.setNombre1(paciente.getUsuario().getNombre1());
            this.usuario.setNombre2(paciente.getUsuario().getNombre2());
            this.usuario.setApellido1(paciente.getUsuario().getApellido1());
            this.usuario.setApellido2(paciente.getUsuario().getApellido2());
            this.usuario.setFechaNac(paciente.getUsuario().getFechaNac());
            this.usuario.setGenero(paciente.getUsuario().getGenero());
            this.usuario.setFoto(paciente.getUsuario().getFoto());
            this.usuario.setDireccion(paciente.getUsuario().getDireccion());

            DaoEstado estado = DaoFactory.DaoEstadoInstancia();
            this.usuario.setEstado(estado.find(paciente.getUsuario().getEstado().getId(), Estado.class));

            DaoTipoUsuario tipoUsuario = DaoFactory.DaoTipoUsuarioInstancia();
            this.usuario.setTipoUsuario(tipoUsuario.find(paciente.getUsuario().getTipoUsuario().getId(), TipoUsuario.class));

            this.paciente.setCedula(paciente.getCedula());
            this.paciente.setEstatus(paciente.getEstatus());

            DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();
            Usuario usuario = daoUsuario.insert(this.usuario);
            this.paciente.setUsuario(daoUsuario.find(usuario.getId(), Usuario.class));
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void execute() {
    }

    public Paciente getResult() {
        DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
        return daoPaciente.insert(this.paciente);
    }

}
