package oncoaliado.Comandos.Ingresos;

import accesos.DaoFactory;
import accesos.Daos.*;
import entidades.*;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoEspecialidadMedico;
import transfer.DtoFactory;

public class ComandoRegistroMedico extends ComandoBase {

    private DtoEspecialidadMedico dtoEspecialidadMedico = DtoFactory.DtoEspecialidadMedicoInstancia();
    private EspecialidadMedico especialidadMedico = FactoryEntidades.EspecialidadMedicoInstancia();

    public ComandoRegistroMedico(DtoEspecialidadMedico dtoEspecialidadMedico) {
        this.dtoEspecialidadMedico = dtoEspecialidadMedico;
    }

    public Usuario addUsuario() {
        Decodificación decoFront = new Decodificación(dtoEspecialidadMedico.getMedico().getUsuario().getContrasena());
        Decodificación decoBack = new Decodificación(decoFront.decodeFront());

        Usuario usuario = FactoryEntidades.UsuarioInstancia();
        DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();

        usuario.setEstatus(this.dtoEspecialidadMedico.getMedico().getUsuario().getEstatus());
        usuario.setCorreo(this.dtoEspecialidadMedico.getMedico().getUsuario().getCorreo());
        usuario.setContrasena(decoBack.encodeBack());
        usuario.setNombre1(this.dtoEspecialidadMedico.getMedico().getUsuario().getNombre1());
        usuario.setNombre2(this.dtoEspecialidadMedico.getMedico().getUsuario().getNombre2());
        usuario.setApellido1(this.dtoEspecialidadMedico.getMedico().getUsuario().getApellido1());
        usuario.setApellido2(this.dtoEspecialidadMedico.getMedico().getUsuario().getApellido2());
        usuario.setFechaNac(this.dtoEspecialidadMedico.getMedico().getUsuario().getFechaNac());
        usuario.setGenero(this.dtoEspecialidadMedico.getMedico().getUsuario().getGenero());
        usuario.setFoto(this.dtoEspecialidadMedico.getMedico().getUsuario().getFoto());
        usuario.setDireccion(this.dtoEspecialidadMedico.getMedico().getUsuario().getDireccion());

        DaoEstado estado = DaoFactory.DaoEstadoInstancia();
        usuario.setEstado(estado.find(this.dtoEspecialidadMedico.getMedico().getUsuario().getEstado().getId(), Estado.class));

        DaoTipoUsuario tipoUsuario = DaoFactory.DaoTipoUsuarioInstancia();
        usuario.setTipoUsuario(tipoUsuario.find(this.dtoEspecialidadMedico.getMedico().getUsuario().getTipoUsuario().getId(), TipoUsuario.class));
        return daoUsuario.insert(usuario);
    }

    public Medico addMedico() {
        Medico medico = FactoryEntidades.MedicoInstancia();
        DaoMedico daoMedico = DaoFactory.DaoMedicoInstancia();

        Usuario usuario = addUsuario();
        medico.setUsuario(usuario);

        medico.setCedula(this.dtoEspecialidadMedico.getMedico().getCedula());
        medico.setEstatus(this.dtoEspecialidadMedico.getMedico().getEstatus());
        medico.setDescripcion(this.dtoEspecialidadMedico.getMedico().getDescripcion());

        return daoMedico.insert(medico);
    }

    public EspecialidadMedico addEspecialidadMedico() {
        Medico medico = addMedico();
        this.especialidadMedico.setMedico(medico);
        this.especialidadMedico.setEstatus(dtoEspecialidadMedico.getEstatus());
        DaoEspecialidad daoEspecialidad = DaoFactory.DaoEspecialidadInstancia();
        this.especialidadMedico.setEspecialidad(daoEspecialidad.find(dtoEspecialidadMedico.getEspecialidad().getId(), Especialidad.class));
        DaoEspecialidaMedico daoEspecialidaMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
        this.especialidadMedico = daoEspecialidaMedico.insert(this.especialidadMedico);
        return this.especialidadMedico;
    }

    @Override
    public void execute() {
    }

    @Override
    public EspecialidadMedico getResult() {
        this.especialidadMedico = addEspecialidadMedico();
        return this.especialidadMedico;
    }

}
