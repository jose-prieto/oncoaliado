package entidades;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "FACTURA", schema = "ONCOALIADO")
public class Factura extends EntidadBase{

    //Atributos
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "comprobante", nullable = false)
    private int comprobante;

    @Column(name = "banco", nullable = false, length = 40)
    private String banco;

    @Column(name = "total", nullable = true, precision = 2)
    private BigDecimal total;

    //Relacion
    @OneToMany(mappedBy = "factura")
    List<Cita> citas;

    //Constructor
    public Factura() {
        super();
    }

    //Getters y Setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getComprobante() {
        return comprobante;
    }

    public void setComprobante(int comprobante) {
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
