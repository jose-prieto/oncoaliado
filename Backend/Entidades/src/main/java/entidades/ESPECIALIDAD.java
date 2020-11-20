package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ESPECIALIDAD")
public class ESPECIALIDAD extends EntidadBase implements Serializable {

    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;

    /*@OneToMany(mappedBy = "especialidad"
    private List<EspecialidadMedico> especialidadMedicoList;*/

    public ESPECIALIDAD() {
    }

    public ESPECIALIDAD(String nombre) {
        this.nombre = nombre;
    }

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

    /*public List<EspecialidadMedico> getEspecialidadMedicoList() {
        return especialidadMedicoList;
    }

    public void setEspecialidadMedicoList(List<EspecialidadMedico> especialidadMedicoList) {
        this.especialidadMedicoList = especialidadMedicoList;
    }*/

}
