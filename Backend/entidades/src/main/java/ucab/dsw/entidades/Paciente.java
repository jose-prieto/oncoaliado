package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "paciente", schema = "ONCOALIADO")
public class Paciente extends EntidadBase {

    //Atributos
    @Column(name = "cedula", nullable = false)
    private int cedula;

    //Relaciones
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "paciente")
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
