package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MEDICO", schema = "ONCOALIADO")
public class Medico extends EntidadBase{

    //Atributos
    @Column(name = "cedula", nullable = false)
    private int cedula;

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    //Relacion
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "medico")
    @JsonbTransient
    List<EspecialidadMedico> especialidades;

    //Constructor
    public Medico() {
    }

    //Getters y Setters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<EspecialidadMedico> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadMedico> especialidades) {
        this.especialidades = especialidades;
    }
}
