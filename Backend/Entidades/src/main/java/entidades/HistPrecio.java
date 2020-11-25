package entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "HIST_PRECIO", schema = "ONCOALIADO")
public class HistPrecio extends EntidadBase{

    //Atributos
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_fin", nullable = true)
    private Date fechaFin;

    @Column(name = "precio", nullable = true, precision = 2)
    private BigDecimal precio;

    //Relacion
    @ManyToOne
    @JoinColumn(name = "id_tipo_cita")
    private TipoCita tipoCita;

    //Constructor

    public HistPrecio() {
        super();
    }

    //Getters y Setters
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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
