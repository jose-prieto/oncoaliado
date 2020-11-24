package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO_CITA", schema = "ONCOALIADO")
public class TipoCita extends EntidadBase{

    //Atributos
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Column(name = "descripcion", nullable = true, length = 100)
    private String descripcion;

    //Relacion
    @OneToMany(mappedBy = "tipoCita")
    List<HistPrecio> precios;

    @OneToMany(mappedBy = "tipoCita")
    List<Cita> citas;

    //Constructor
    public TipoCita() {
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<HistPrecio> getPrecios() {
        return precios;
    }

    public void setPrecios(List<HistPrecio> precios) {
        this.precios = precios;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
