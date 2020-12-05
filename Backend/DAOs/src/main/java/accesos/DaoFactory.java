package accesos;

import accesos.Daos.*;

public class DaoFactory {

    public static DaoCita DaoCitaInstancia() {
        return new DaoCita();
    }

    public static DaoEspecialidad DaoEspecialidadInstancia() {
        return new DaoEspecialidad();
    }

    public static DaoEspecialidaMedico DaoEspecialidaMedicoInstancia() {
        return new DaoEspecialidaMedico();
    }

    public static DaoEstado DaoEstadoInstancia() {
        return new DaoEstado();
    }

    public static DaoEvento DaoEventoInstancia() {
        return new DaoEvento();
    }

    public static DaoFactura DaoFacturaInstancia() {
        return new DaoFactura();
    }

    public static DaoHistCambio DaoHistCambioInstancia() {
        return new DaoHistCambio();
    }

    public static DaoHistPrecio DaoHistPrecioInstancia() {
        return new DaoHistPrecio();
    }

    public static DaoMedico DaoMedicoInstancia() {
        return new DaoMedico();
    }

    public static DaoPaciente DaoPacienteInstancia() {
        return new DaoPaciente();
    }

    public static DaoPais DaoPaisInstancia() {
        return new DaoPais();
    }

    public static DaoTipoCita DaoTipoCitaInstancia() {
        return new DaoTipoCita();
    }

    public static DaoTipoUsuario DaoTipoUsuarioInstancia() {
        return new DaoTipoUsuario();
    }

    public static DaoUsuario DaoUsuarioInstancia() {
        return new DaoUsuario();
    }

}
