package entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

//Entidad que servirá de base para el DaoHandler para la mayoría de Entidades
@MappedSuperclass
public class EntidadBase implements Serializable {

    //Atributos
    @Id
    @Column( name = "Id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @Column( name = "estatus" )
    private String estatus;

    //Constructor
    public EntidadBase() {
    }

    //Getters y Setters
    public long getId() {
        return id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus( String estatus ) {
        this.estatus = estatus;
    }

}
