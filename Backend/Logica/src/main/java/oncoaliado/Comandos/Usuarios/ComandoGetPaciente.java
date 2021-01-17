package oncoaliado.Comandos.Usuarios;

import accesos.DaoFactory;
import accesos.Daos.DaoPaciente;
import accesos.Daos.DaoUsuario;
import entidades.FactoryEntidades;
import entidades.Paciente;
import entidades.Usuario;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import oncoaliado.Comandos.Ingresos.Decodificación;
import transfer.DtoUsuarioCorreo;

public class ComandoGetPaciente extends ComandoBase {

    private final String correo;
    private Paciente paciente = FactoryEntidades.PacienteInstancia();

    public ComandoGetPaciente(DtoUsuarioCorreo dtoUsuarioCorreo) throws Excepciones {
        if (dtoUsuarioCorreo.getCorreo() == null) {
            throw new Excepciones("La correo no debe ser null.");
        }
        this.correo = dtoUsuarioCorreo.getCorreo();
    }

    @Override
    public void execute() {
        DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
        this.paciente = daoPaciente.getPacienteCedula(this.correo);
        if(this.paciente != null) {
            Decodificación decoBack = new Decodificación(this.paciente.getUsuario().getContrasena());
            Decodificación encoFront = new Decodificación(decoBack.decodeBack());
            Usuario usuario = this.paciente.getUsuario();
            usuario.setContrasena(encoFront.encodeFront());
            this.paciente.setUsuario(usuario);
        }
    }

    @Override
    public Paciente getResult() {
        execute();
        return this.paciente;
    }

}
