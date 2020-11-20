package entidades;

import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PACIENTE")
public class PACIENTE implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    /*@OneToMany(mappedBy = "paciente")
    private List<Cita> citaList;*/

    @PrimaryKeyJoinColumn(name = "correo", referencedColumnName = "correo")
    @ManyToOne
    private USUARIO usuario;

    public PACIENTE() {
    }

    public PACIENTE(int id) {
        this.id = id;
    }

    /*public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }*/

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }

}