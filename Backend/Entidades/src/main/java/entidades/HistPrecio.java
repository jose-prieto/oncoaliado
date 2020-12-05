package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "HIST_PRECIO", schema = "ONCOALIADO")
public class HistPrecio extends EntidadBase{

    //Atributos
    @Column(name = "fecha_inicio", nullable = false)
    private GregorianCalendar fechaInicio;

    @Column(name = "fecha_fin", nullable = true)
    private GregorianCalendar fechaFin;

    @Column(name = "precio", nullable = true, precision = 2)
    private BigDecimal precio;

    //Relacion
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_cita", referencedColumnName = "id")
    private TipoCita tipoCita;

    //Constructor

    public HistPrecio() {
        super();
    }

    //Getters y Setters
    public GregorianCalendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(GregorianCalendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public GregorianCalendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(GregorianCalendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public TipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(TipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }
}
