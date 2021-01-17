package transfer;

import java.util.GregorianCalendar;

public class DtoUsuario extends DtoBase {

    //Atributos
    private String correo;
    private String contrasena;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private GregorianCalendar fechaNac;
    private String genero;
    private String foto;
    private String direccion;
    private String estatus;

    //Relaciones
    private DtoEstado estado;
    private DtoTipoUsuario tipoUsuario;

    //Constructor
    public DtoUsuario() {
        super();
    }

    //Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public DtoEstado getEstado() {
        return estado;
    }

    public void setEstado(DtoEstado estado) {
        this.estado = estado;
    }

    public DtoTipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(DtoTipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
