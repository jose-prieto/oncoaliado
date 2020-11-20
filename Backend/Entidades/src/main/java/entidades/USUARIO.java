package entidades;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "USUARIO")
public class USUARIO implements Serializable {

    @Id
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;

    @Size(min = 1, max = 30)
    @Column(name = "contrasena")
    private String contrasena;

    @Size(min = 1, max = 50)
    @Column(name = "nombre1")
    private String nombre1;

    @Size(max = 50)
    @Column(name = "nombre2")
    private String nombre2;

    @Size(min = 1, max = 50)
    @Column(name = "apellido1")
    private String apellido1;

    @Size(max = 50)
    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "fechaNac")
    private GregorianCalendar fechaNac;

    @Size(min = 1, max = 50)
    @Column(name = "genero")
    private String genero;

    @Lob
    @Column(name = "foto")
    private byte[] foto;

    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;

    @OneToMany(mappedBy = "usuario")
    private List<HIST_CAMBIO> histCambioList;

    @JoinColumns({
            @JoinColumn(name = "id_estado", referencedColumnName = "id"),
            @JoinColumn(name = "id_pais", referencedColumnName = "id_pais")})
    @ManyToOne(optional = false)
    private ESTADO estado;

    @OneToMany(mappedBy = "usuario")
    private List<MEDICO> medicoList;

    @OneToMany(mappedBy = "usuario")
    private List<PACIENTE> pacienteList;

    public USUARIO() {
    }

    public USUARIO(String correo) {
        this.correo = correo;
    }

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

    public List<HIST_CAMBIO> getHistCambioList() {
        return histCambioList;
    }

    public void setHistCambioList(List<HIST_CAMBIO> histCambioList) {
        this.histCambioList = histCambioList;
    }

    public ESTADO getEstado() {
        return estado;
    }

    public void setEstado(ESTADO estado) {
        this.estado = estado;
    }

    public List<MEDICO> getMedicoList() {
        return medicoList;
    }

    public void setMedicoList(List<MEDICO> medicoList) {
        this.medicoList = medicoList;
    }

    public List<PACIENTE> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<PACIENTE> pacienteList) {
        this.pacienteList = pacienteList;
    }

}