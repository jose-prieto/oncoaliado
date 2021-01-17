package oncoaliado.Comandos.Usuarios;

import accesos.DaoFactory;
import accesos.Daos.DaoEspecialidaMedico;
import entidades.EspecialidadMedico;
import entidades.Medico;
import entidades.Usuario;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import oncoaliado.Comandos.Ingresos.Decodificación;
import transfer.DtoUsuarioCorreo;

public class ComandoGetMedico extends ComandoBase {

    private final String correo;
    private EspecialidadMedico especialidadMedico;

    public ComandoGetMedico(DtoUsuarioCorreo dtoUsuarioCorreo) throws Excepciones {
        if (dtoUsuarioCorreo.getCorreo() == null) {
            throw new Excepciones("El correo no debe ser null.");
        }
        this.correo = dtoUsuarioCorreo.getCorreo();
    }

    @Override
    public void execute() throws Excepciones {
        DaoEspecialidaMedico daoEspecialidaMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
        this.especialidadMedico = daoEspecialidaMedico.getEspecialidadMedicoCorreo(this.correo);

        if(this.especialidadMedico != null) {
            Decodificación decoBack = new Decodificación(this.especialidadMedico.getMedico().getUsuario().getContrasena());
            Decodificación encoFront = new Decodificación(decoBack.decodeBack());

            Usuario usuario = this.especialidadMedico.getMedico().getUsuario();
            usuario.setContrasena(encoFront.encodeFront());
            Medico medico = this.especialidadMedico.getMedico();
            medico.setUsuario(usuario);
            this.especialidadMedico.setMedico(medico);
        }
    }

    @Override
    public EspecialidadMedico getResult() throws Excepciones {
        execute();
        return this.especialidadMedico;
    }

}
