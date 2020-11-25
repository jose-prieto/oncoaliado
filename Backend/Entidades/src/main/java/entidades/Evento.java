package entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;

@Entity
@Table(name = "evento", schema = "ONCOALIADO")
public class Evento extends EntidadBase{

    //Atributos
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "contenido", nullable = true, length = 10000)
    private String contenido;

    @Column(name = "direccion", nullable = true, length = 200)
    private String direccion;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "foto", nullable = true)
    private byte[] foto;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    //relacion
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    //Constructor
    public Evento() {
        super();
    }

    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
