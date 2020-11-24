package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_USUARIO", schema = "ONCOALIADO")
public class TipoUsuario extends EntidadBase{

    //Atributos
    @Column(name = "tipo", nullable = false)
    private Object tipo;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    //Relacion
    @OneToMany(mappedBy = "tipoUsuario")
    List<Usuario> usuarios;

    //Constructor
    public TipoUsuario() {
        super();
    }

    //Getters y Setters
    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
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
