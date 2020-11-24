package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "HIST_CAMBIO", schema = "ONCOALIADO")
public class HistCambio extends EntidadBase{

    //Atributos
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "id_usuario", nullable = false)
    private int idUsuario;

    //Relacion
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    //Constructor
    public HistCambio() {
    }

    //Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
