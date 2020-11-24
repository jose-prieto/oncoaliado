package ucab.dsw.entidades;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "ONCOALIADO")
public class Usuario extends EntidadBase{

    //Atributos
    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 30)
    private String contrasena;

    @Column(name = "nombre1", nullable = false, length = 50)
    private String nombre1;

    @Column(name = "nombre2", nullable = true, length = 50)
    private String nombre2;

    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;

    @Column(name = "apellido2", nullable = true, length = 50)
    private String apellido2;

    @Column(name = "fechaNac", nullable = false)
    private Date fechaNac;

    @Column(name = "genero", nullable = false)
    private Object genero;

    @Column(name = "foto", nullable = true)
    private byte[] foto;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy = "id_usuario")
    List<HistCambio> cambios;

    @OneToOne(mappedBy = "usuario")
    Paciente paciente;

    @OneToOne(mappedBy = "usuario")
    Medico medico;

    //Constructor
    public Usuario() {
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Object getGenero() {
        return genero;
    }

    public void setGenero(Object genero) {
        this.genero = genero;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<HistCambio> getCambios() {
        return cambios;
    }

    public void setCambios(List<HistCambio> cambios) {
        this.cambios = cambios;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
