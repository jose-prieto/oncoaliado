package oncoaliado.Comandos;

import oncoaliado.Comandos.Citas.*;
import oncoaliado.Comandos.Correos.ComandoCorreo;
import oncoaliado.Comandos.Eventos.*;
import oncoaliado.Comandos.Ingresos.ComandoLogin;
import oncoaliado.Comandos.Ingresos.ComandoRegistroMedico;
import oncoaliado.Comandos.Ingresos.ComandoRegistroPaciente;
import oncoaliado.Comandos.Lugares.ComandoGetEstados;
import oncoaliado.Comandos.Lugares.ComandoGetLugares;
import oncoaliado.Comandos.Lugares.ComandoGetPaises;
import oncoaliado.Comandos.Medicos.ComandoGetAllMedicos;
import transfer.*;

import java.util.List;

public class ComandoFactory {

    //Eventos
    public static ComandoGetAllEventos ComandoEventoInstance() {
        return new ComandoGetAllEventos();
    }

    public static ComandoGetEventosActivos ComandoEventosActivosInstance() {
        return new ComandoGetEventosActivos();
    }

    public static ComandoPutEvento ComandoPutEventoInstancia(DtoEvento dtoEvento) {
        return new ComandoPutEvento(dtoEvento);
    }

    public static ComandoUpdateEvento ComandoUpdateEventoInstance(DtoEvento evento, long id) {
        return new ComandoUpdateEvento(evento, id);
    }

    //Medicos
    public static ComandoGetAllMedicos ComandoGetAllMedicosInstance() {
        return new ComandoGetAllMedicos();
    }

    //Login
    public static ComandoLogin ComandoLoginInstance(DtoLogin dtoLogin) {
        return new ComandoLogin(dtoLogin);
    }

    //Registro
    public static ComandoRegistroPaciente ComandoRegistroPacienteInstancia(DtoPaciente dtoPaciente) {
        return new ComandoRegistroPaciente(dtoPaciente);
    }

    public static ComandoRegistroMedico ComandoRegistroMedicoInstancia(DtoEspecialidadMedico dtoEspecialidadMedico) {
        return new ComandoRegistroMedico(dtoEspecialidadMedico);
    }

    //Citas
    public static ComandoGetAllCitas ComandoGetAllCitasInstancia() {
        return new ComandoGetAllCitas();
    }

    public static ComandoGetAllCitasMedico ComandoGetAllCitasMedicoInstancia(long id) {
        return new ComandoGetAllCitasMedico(id);
    }

    public static ComandoGenerarCitas ComandoGenerarCitasInstancia(long id, List<DtoGenerarCitas> dtoGenerarCitas) {
        return new ComandoGenerarCitas(id, dtoGenerarCitas);
    }

    public static ComandoGetAllCitasPaciente ComandoGetAllCitasPacienteInstancia(long id) {
        return new ComandoGetAllCitasPaciente(id);
    }

    public static ComandoUpdateCita ComandoUpdateCitaInstancia(DtoCita dtoCita) {
        return new ComandoUpdateCita(dtoCita);
    }

    //Correos
    public static ComandoCorreo ComandoCorreoPreguntaInstancia(DtoCorreo dtoCorreo) {
        return new ComandoCorreo(dtoCorreo);
    }

    //Lugares
    public static ComandoGetLugares ComandoGetLugaresInstancia() {
        return new ComandoGetLugares();
    }

    public static ComandoGetEstados ComandoGetEstadosInstancia(long idPais) {
        return new ComandoGetEstados(idPais);
    }

    public static ComandoGetPaises ComandoGetPaisesInstancia() {
        return new ComandoGetPaises();
    }

}
