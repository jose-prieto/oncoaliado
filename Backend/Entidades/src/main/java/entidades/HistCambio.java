package entidades;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.sql.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "HIST_CAMBIO", schema = "ONCOALIADO")
public class HistCambio extends EntidadBase{

    //Atributos
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private GregorianCalendar fecha;

    //Relacion
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
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

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
