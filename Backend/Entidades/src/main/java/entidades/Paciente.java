package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PACIENTE", schema = "ONCOALIADO")
@NamedQueries({
        @NamedQuery(name = "getPacienteCorreo", query = "SELECT p FROM Paciente p WHERE p.usuario.correo = :correo")
})
public class Paciente extends EntidadBase {

    //Atributos
    @Column(name = "cedula", nullable = false)
    private int cedula;

    //Relaciones
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "paciente")
    @JsonbTransient
    List<Cita> citas;

    //Constructor
    public Paciente() {
        super();
    }

    //Getters y Setters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
