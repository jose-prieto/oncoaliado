package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_USUARIO", schema = "ONCOALIADO")
public class TipoUsuario extends EntidadBase{

    //Atributos
    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    //Relacion
    @OneToMany(mappedBy = "tipoUsuario")
    @JsonbTransient
    List<Usuario> usuarios;

    //Constructor
    public TipoUsuario() {
        super();
    }

    //Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
