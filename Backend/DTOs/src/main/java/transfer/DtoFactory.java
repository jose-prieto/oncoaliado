package transfer;

public class DtoFactory {

    public static DtoCita DtoCitaInstancia() {
        return new DtoCita();
    }

    public static DtoEspecialidad DtoEspecialidadInstancia() {
        return new DtoEspecialidad();
    }

    public static DtoEspecialidadMedico DtoEspecialidadMedicoInstancia() {
        return new DtoEspecialidadMedico();
    }

    public static DtoEstado DtoEstadoInstancia(long id) throws Exception {
        return new DtoEstado(id);
    }

    public static DtoEvento DtoEventoInstancia() {
        return new DtoEvento();
    }

    public static DtoFactura DtoFacturaInstancia() {
        return new DtoFactura();
    }

    public static DtoHistCambio DtoHistCambioInstancia() {
        return new DtoHistCambio();
    }

    public static DtoHistPrecio DtoHistPrecioInstancia() {
        return new DtoHistPrecio();
    }

    public static DtoMedico DtoMedicoInstancia() {
        return new DtoMedico();
    }

    public static DtoPaciente DtoPacienteInstancia() {
        return new DtoPaciente();
    }

    public static DtoPais DtoPaisInstancia() {
        return new DtoPais();
    }

    public static DtoTipoCita DtoTipoCitaInstancia() {
        return new DtoTipoCita();
    }

    public static DtoTipoUsuario DtoTipoUsuarioInstancia() {
        return new DtoTipoUsuario();
    }

    public static DtoUsuario DtoUsuarioInstancia() {
        return new DtoUsuario();
    }

    public static DtoInfoLogin DtoInfoLoginInstancia(String correo, String rol, String nombre, String apellido) {
        return new DtoInfoLogin(correo,rol,nombre,apellido);
    }

    public static DtoLogin DtoLoginInstancia() {
        return new DtoLogin();
    }

}
