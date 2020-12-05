package entidades;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Table(name = "EVENTO", schema = "ONCOALIADO")
public class Evento extends EntidadBase{

    //Atributos
    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "contenido", length = 10000)
    private String contenido;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "foto")
    private String foto;

    @Column(name = "fecha", nullable = false)
    private GregorianCalendar fecha;

    //relacion
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
