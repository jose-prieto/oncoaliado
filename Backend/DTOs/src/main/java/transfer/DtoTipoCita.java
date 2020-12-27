package transfer;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

public class DtoTipoCita extends DtoBase {

    //Atributos
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    //Constructor
    public DtoTipoCita() {

    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
