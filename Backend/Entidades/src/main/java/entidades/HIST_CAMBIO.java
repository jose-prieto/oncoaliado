package entidades;

import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.GregorianCalendar;

@Entity
@Table(name = "HIST_CAMBIO")
public class HIST_CAMBIO extends EntidadBase implements Serializable {

    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha")
    private GregorianCalendar fecha;

    @PrimaryKeyJoinColumn(name = "correo", referencedColumnName = "correo")
    @ManyToOne(optional = false)
    private USUARIO usuario;

    public HIST_CAMBIO() {
    }

    public HIST_CAMBIO(int id) {
        super(id);
    }

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

    public USUARIO getUsuario() {
        return usuario;
    }

    public void setUsuario(USUARIO usuario) {
        this.usuario = usuario;
    }
}