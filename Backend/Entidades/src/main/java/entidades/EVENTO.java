package entidades;

import org.eclipse.persistence.annotations.PrimaryKey;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.GregorianCalendar;

@Entity
@Table(name = "EVENTO")
public class EVENTO extends EntidadBase implements Serializable {

    @Size(min = 1, max = 200)
    @Column(name = "titulo")
    private String titulo;

    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;

    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;

    @Size(min = 1, max = 50)
    @Column(name = "estatus")
    private String estatus;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "fecha")
    private GregorianCalendar fecha;

    @JoinColumns({
            @JoinColumn(name = "id_estado", referencedColumnName = "id"),
            @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")})
    @ManyToOne(fetch = FetchType.LAZY)
    private ESTADO estado;

    public EVENTO() {
    }

    public EVENTO(int id) {
        super(id);
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }
}