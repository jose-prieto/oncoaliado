package transfer;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

public class DtoMedico extends DtoBase {

    //Atributos
    private int cedula;
    private String descripcion;
    private String estatus;

    //Relacion
    private DtoUsuario usuario;

    //Constructor
    public DtoMedico() {
    }

    //Getters y Setters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DtoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(DtoUsuario usuario) {
        this.usuario = usuario;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
