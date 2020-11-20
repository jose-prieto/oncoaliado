package entidades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ESTADO")
public class ESTADO extends EntidadBase implements Serializable {

    //Atributos
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "estado")
    private List<USUARIO> usuarioList;

    @OneToMany(mappedBy = "estado")
    private List<EVENTO> eventoList;

    @PrimaryKeyJoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne
    private PAIS pais;

    //Constructores
    public ESTADO() {
    }

    public ESTADO(int id) {
        super(id);
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<USUARIO> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<USUARIO> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<EVENTO> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<EVENTO> eventoList) {
        this.eventoList = eventoList;
    }

    public PAIS getPais() {
        return pais;
    }

    public void setPais(PAIS pais) {
        this.pais = pais;
    }
}