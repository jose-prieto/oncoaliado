package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pais", schema = "ONCOALIADO")
public class Pais extends EntidadBase{

    //Entidad
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    //Relacion
    @OneToMany(mappedBy = "pais")
    List<Estado> estados;

    //Constructor
    public Pais() {
        super();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
