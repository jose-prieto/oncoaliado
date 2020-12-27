package entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

@Entity
@Table(name = "CITA", schema = "ONCOALIADO")
@NamedQueries({
        @NamedQuery(name = "GetCitasMedico", query = "SELECT c FROM Cita c WHERE c.medico.medico = :medico"),
        @NamedQuery(name = "GetCitasPaciente", query = "SELECT c FROM Cita c WHERE c.paciente = :paciente"),
        @NamedQuery(name = "GetCitasPendiente", query = "SELECT c FROM Cita c WHERE c.estatus = :estatus AND c.factura.estatus = :estatusFactura"),
        @NamedQuery(name = "GetCitasInactivas", query = "SELECT c FROM Cita c WHERE c.estatus = :estatus AND c.medico = :medicoEspecialidad"),
        @NamedQuery(name = "getPrecio", query = "SELECT h.precio FROM HistPrecio h WHERE h.estatus = 'a' AND h.tipoCita = :tipoCita")
})
public class Cita extends EntidadBase{

    //Atributos
    @Column(name = "fecha", nullable = false)
    private GregorianCalendar fecha;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "precio", precision = 2)
    private BigDecimal precio;

    //Relaciones
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico_especialidad", referencedColumnName = "id")
    private EspecialidadMedico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico_diagnostico", referencedColumnName = "id")
    private EspecialidadMedico medicoDiagnostico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_factura", referencedColumnName = "id")
    private Factura factura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_cita", referencedColumnName = "id")
    private TipoCita tipoCita;

    //Constructor
    public Cita() {
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
