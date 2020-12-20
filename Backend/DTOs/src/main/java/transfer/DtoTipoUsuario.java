package transfer;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class DtoTipoUsuario extends DtoBase {

    //Atributos
    private String tipo;
    private String descripcion;

    //Constructor
    public DtoTipoUsuario() {
        super();
    }

    //Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
