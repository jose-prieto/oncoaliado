package entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class EntidadBase implements Serializable {

    @Id
    @Column( name = "Id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    public EntidadBase() {

    }

    public EntidadBase( int id ) {

        this.id = id;

    }

    public int get_id() {

        return this.id;

    }

}
