package entidades;

import javax.json.bind.annotation.JsonbTransient;
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
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medico_especialidad", referencedColumnName = "id")
    private EspecialidadMedico medico;

    @ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico_diagnostico", referencedColumnName = "id")
    private EspecialidadMedico medicoDiagnostico;

    @ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne(optional = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura factura;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_cita", referencedColumnName = "id")
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
