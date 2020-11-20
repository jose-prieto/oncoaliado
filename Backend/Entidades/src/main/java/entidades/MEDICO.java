package entidades;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "MEDICO")
public class MEDICO implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;

    /*@OneToMany(mappedBy = "medico")
    private List<EspecialidadMedico> especialidadMedicoList;*/

    @PrimaryKeyJoinColumn(name = "correo", referencedColumnName = "correo")
    @ManyToOne(optional = false)
    private USUARIO usuario;

    public MEDICO() {
    }

    public MEDICO(int id) {
        this.id = id;
    }

    public MEDICO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }

}