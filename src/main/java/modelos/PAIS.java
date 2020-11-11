package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PAIS")
public class PAIS implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "INT NOT NULL")
    private int id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(60) NOT NULL")
    private String nombre;

    @OneToMany(mappedBy = "pais")
    private List<ESTADO> estados = new ArrayList<>(); 

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

    public List<ESTADO> getEstados() {
        return estados;
    }

    public void setEstados(List<ESTADO> estados) {
        this.estados = estados;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.estados);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PAIS other = (PAIS) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.estados, other.estados)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PAIS{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
