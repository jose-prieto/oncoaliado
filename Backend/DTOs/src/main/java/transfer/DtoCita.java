package transfer;

import java.sql.Date;
import java.util.GregorianCalendar;

public class DtoCita extends DtoBase {

    //Atributos
    private GregorianCalendar fecha;

    private String descripcion;

    private String estatus;

    //Relaciones
    private DtoEspecialidadMedico medico;

    private DtoEspecialidadMedico medicoDiagnostico;

    private DtoPaciente paciente;

    private DtoFactura factura;

    private DtoTipoCita tipoCita;

    //Constructor
    public DtoCita() {
        super();
    }

    //Getters y Setters
    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DtoEspecialidadMedico getMedico() {
        return medico;
    }

    public void setMedico(DtoEspecialidadMedico medico) {
        this.medico = medico;
    }

    public DtoEspecialidadMedico getMedicoDiagnostico() {
        return medicoDiagnostico;
    }

    public void setMedicoDiagnostico(DtoEspecialidadMedico medicoDiagnostico) {
        this.medicoDiagnostico = medicoDiagnostico;
    }

    public DtoPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(DtoPaciente paciente) {
        this.paciente = paciente;
    }

    public DtoFactura getFactura() {
        return factura;
    }

    public void setFactura(DtoFactura factura) {
        this.factura = factura;
    }

    public DtoTipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(DtoTipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
