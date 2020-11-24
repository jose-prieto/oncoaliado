package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tipopregunta" )
public class TipoPregunta extends EntidadBase{

    @Column( name = "descripcion", nullable = false )
    private String descripcion;

    public String get_descripcion()
    {
        return descripcion;
    }

    public void set_descripcion( String descripcion )
    {
        this.descripcion = descripcion;
    }

    public TipoPregunta(){

    }

    public TipoPregunta( long id ) {
        super(id);
    }

}