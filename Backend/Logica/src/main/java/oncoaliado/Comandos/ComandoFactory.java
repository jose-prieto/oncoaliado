package oncoaliado.Comandos;

import excepciones.Excepciones;
import oncoaliado.Comandos.Citas.*;
import oncoaliado.Comandos.Correos.ComandoCorreo;
import oncoaliado.Comandos.Especialidades.ComandoGetAllEspecialidades;
import oncoaliado.Comandos.Eventos.*;
import oncoaliado.Comandos.Factura.ComandoPagarFactura;
import oncoaliado.Comandos.Ingresos.ComandoLogin;
import oncoaliado.Comandos.Ingresos.ComandoRegistroMedico;
import oncoaliado.Comandos.Ingresos.ComandoRegistroPaciente;
import oncoaliado.Comandos.Lugares.ComandoGetEstados;
import oncoaliado.Comandos.Lugares.ComandoGetLugares;
import oncoaliado.Comandos.Lugares.ComandoGetPaises;
import oncoaliado.Comandos.Medicos.ComandoGetAllMedicos;
import oncoaliado.Comandos.TipoCita.ComandoGetTipoCitas;
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

    public static ComandoPostEvento ComandoPutEventoInstancia(DtoEvento dtoEvento) throws Excepciones{
        return new ComandoPostEvento(dtoEvento);
    }

    public static ComandoUpdateEvento ComandoUpdateEventoInstance(DtoEvento evento) throws Excepciones {
        return new ComandoUpdateEvento(evento);
    }

    public static ComandoGetEvento ComandoGetEventoInstancia(long id) {
        return new ComandoGetEvento(id);
    }

    //Medicos
    public static ComandoGetAllMedicos ComandoGetAllMedicosInstance() {
        return new ComandoGetAllMedicos();
    }

    //Login
    public static ComandoLogin ComandoLoginInstance(DtoLogin dtoLogin) throws Excepciones{
        return new ComandoLogin(dtoLogin);
    }

    //Registro
    public static ComandoRegistroPaciente ComandoRegistroPacienteInstancia(DtoPaciente dtoPaciente) throws Excepciones{
        return new ComandoRegistroPaciente(dtoPaciente);
    }

    public static ComandoRegistroMedico ComandoRegistroMedicoInstancia(DtoEspecialidadMedico dtoEspecialidadMedico) throws Excepciones {
        return new ComandoRegistroMedico(dtoEspecialidadMedico);
    }

    //Citas
    public static ComandoGetCita ComandoGetCitaInstancia(long idCita) throws Excepciones{
        return new ComandoGetCita(idCita);
    }

    public static ComandoGetAllCitas ComandoGetAllCitasInstancia() {
        return new ComandoGetAllCitas();
    }

    public static ComandoGetAllCitasMedico ComandoGetAllCitasMedicoInstancia(long id) throws Excepciones{
        return new ComandoGetAllCitasMedico(id);
    }

    public static ComandoGenerarCitas ComandoGenerarCitasInstancia(long id, List<DtoGenerarCitas> dtoGenerarCitas) throws Excepciones {
        return new ComandoGenerarCitas(id, dtoGenerarCitas);
    }

    public static ComandoGetAllCitasPaciente ComandoGetAllCitasPacienteInstancia(long id) {
        return new ComandoGetAllCitasPaciente(id);
    }

    public static ComandoUpdateCita ComandoUpdateCitaInstancia(DtoCita dtoCita) throws Excepciones{
        return new ComandoUpdateCita(dtoCita);
    }

    public static ComandoGetCitasPendientes ComandoGetCitasPendientesInstancia() {
        return new ComandoGetCitasPendientes();
    }

    public static ComandoGetCitasInactivas ComandoGetCitasInactivasInstancia(long id) throws Excepciones {
        return new ComandoGetCitasInactivas(id);
    }

    public static ComandoApartarCita ComandoApartarCitaInstancia(long citaId, long usrId, long tipoCitaId) throws Excepciones {
        return new ComandoApartarCita(citaId, usrId, tipoCitaId);
    }

    public static ComandoPagarFactura ComandoPagarFacturaInstancia(DtoFactura dtoFactura) throws Excepciones{
        return new ComandoPagarFactura(dtoFactura);
    }

    //TipoCitas
    public static ComandoGetTipoCitas ComandoGetTipoCitasInstancia() {
        return new ComandoGetTipoCitas();
    }

    //Especialidades
    public static ComandoGetAllEspecialidades ComandoGetAllEspecialidadesInstancia() {
        return new ComandoGetAllEspecialidades();
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
