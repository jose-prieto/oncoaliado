package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class PAIS {

    @Id
    @Column(name = "id", columnDefinition = "INT NOT NULL")
    private int id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(60) NOT NULL")
    private String nombre;

    public PAIS() {
        
    }

    public PAIS(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
