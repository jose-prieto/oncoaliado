package entidades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "PAIS")
public class PAIS extends EntidadBase{

    //Atributos
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "pais")
    private List<ESTADO> estadoList;

    //Constructores
    public PAIS() {

    }

    public PAIS(int id) {
        super(id);
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ESTADO> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<ESTADO> estadoList) {
        this.estadoList = estadoList;
    }

}
