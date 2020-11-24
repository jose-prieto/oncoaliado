package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "especialidad", schema = "ONCOALIADO")
public class Especialidad extends EntidadBase{

    //Atributos
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "descripcion", nullable = true, length = 100)
    private String descripcion;

    //Relaciones
    @OneToMany(mappedBy = "especialidad")
    List<EspecialidadMedico> medico;

    //Constructos

    public Especialidad() {
        super();
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

    public List<EspecialidadMedico> getMedico() {
        return medico;
    }

    public void setMedico(List<EspecialidadMedico> medico) {
        this.medico = medico;
    }
}
