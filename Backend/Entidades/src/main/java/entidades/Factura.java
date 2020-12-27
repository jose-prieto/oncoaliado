package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "FACTURA", schema = "ONCOALIADO")
public class Factura extends EntidadBase{

    //Atributos
    @Column(name = "fecha")
    private GregorianCalendar fecha;

    @Column(name = "comprobante", length = 200)
    private String comprobante;

    @Column(name = "banco", length = 100)
    private String banco;

    @Column(name = "total", nullable = false, precision = 2)
    private BigDecimal total;

    //Relacion
    @JsonbTransient
    @OneToMany(mappedBy = "factura")
    List<Cita> citas;

    //Constructor
    public Factura() {
        super();
    }

    //Getters y Setters
    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
