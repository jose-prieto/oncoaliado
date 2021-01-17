package transfer;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class DtoFactura extends DtoBase {

    //Atributos
    private GregorianCalendar fecha;
    private String comprobante;
    private String banco;
    private BigDecimal total;
    private String estatus;

    //Contructor
    public DtoFactura() {

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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
