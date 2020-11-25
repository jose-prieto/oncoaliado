package entidades;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CITA", schema = "ONCOALIADO")
public class Cita extends EntidadBase{

    //Atributos
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_medico_especialidad")
    private EspecialidadMedico medico;

    @ManyToOne
    @JoinColumn(name = "id_medico_diagnostico")
    private EspecialidadMedico medicoDiagnostico;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cita")
    private TipoCita tipoCita;

    //Constructor
    public Cita() {
        super();
    }

    //Getters y Setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EspecialidadMedico getMedico() {
        return medico;
    }

    public void setMedico(EspecialidadMedico medico) {
        this.medico = medico;
    }

    public EspecialidadMedico getMedicoDiagnostico() {
        return medicoDiagnostico;
    }

    public void setMedicoDiagnostico(EspecialidadMedico medicoDiagnostico) {
        this.medicoDiagnostico = medicoDiagnostico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public TipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(TipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }
}
