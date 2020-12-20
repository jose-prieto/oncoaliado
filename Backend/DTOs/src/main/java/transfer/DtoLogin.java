package transfer;

public class DtoLogin {

    //Atributos
    private String password;
    private String correo;

    //Constructores
    public DtoLogin() {
    }

    //Getters y Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
