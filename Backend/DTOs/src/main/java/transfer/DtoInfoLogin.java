package transfer;

public class DtoInfoLogin {

    //Atributos
    private String correo;
    private String rol;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private long paciente;
    private long medico;

    //Constructor
    public DtoInfoLogin() {

    }

    public DtoInfoLogin(String correo, String rol, String nombre1, String apellido1) {
        this.correo = correo;
        this.rol = rol;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
    }

    //Getters y Setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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

    public long getPaciente() {
        return paciente;
    }

    public void setPaciente(long paciente) {
        this.paciente = paciente;
    }

    public long getMedico() {
        return medico;
    }

    public void setMedico(long medico) {
        this.medico = medico;
    }
}
