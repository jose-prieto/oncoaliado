package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ESTADO", schema = "ONCOALIADO")
@NamedQueries({
        @NamedQuery(name = "GetEstadosByPais", query = "SELECT e FROM Estado e WHERE e.pais = :pais")
})
public class Estado extends EntidadBase {

    //Atributos
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    //Relaciones
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    private Pais pais;

    @JsonbTransient
    @OneToMany(mappedBy = "estado")
    List<Evento> eventos;

    @JsonbTransient
    @OneToMany(mappedBy = "estado")
    List<Usuario> usuarios;

    //Constructor
    public Estado() {
        super();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
