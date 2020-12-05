package entidades;

public class FactoryEntidades {

    public static Cita CitaInstancia() {
        return new Cita();
    }

    public static Especialidad EspecialidadInstancia() {
        return new Especialidad();
    }

    public static EspecialidadMedico EspecialidadMedicoInstancia() {
        return new EspecialidadMedico();
    }

    public static Estado EstadoInstancia() {
        return new Estado();
    }

    public static Estado EstadoInstancia(long id) {
        return new Estado(id);
    }

    public static Evento EventoInstancia() {
        return new Evento();
    }

    public static Factura FacturaInstancia() {
        return new Factura();
    }

    public static HistCambio HistCambioInstancia() {
        return new HistCambio();
    }

    public static HistPrecio HistPrecioInstancia() {
        return new HistPrecio();
    }

    public static Medico MedicoInstancia() {
        return new Medico();
    }

    public static Paciente PacienteInstancia() {
        return new Paciente();
    }

    public static Pais PaisInstancia() {
        return new Pais();
    }

    public static TipoCita TipoCitaInstancia() {
        return new TipoCita();
    }

    public static TipoUsuario TipoUsuarioInstancia() {
        return new TipoUsuario();
    }

    public static Usuario UsuarioInstancia() {
        return new Usuario();
    }

}
