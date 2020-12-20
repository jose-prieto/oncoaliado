package oncoaliado.Comandos.Ingresos;

import accesos.DaoFactory;
import accesos.Daos.DaoUsuario;
import entidades.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoFactory;
import transfer.DtoInfoLogin;
import transfer.DtoLogin;

import javax.json.Json;
import javax.json.JsonObject;
import java.util.Date;
import java.util.List;

public class ComandoLogin extends ComandoBase {

    private Usuario usuario;
    private String pass;
    private String correo;
    private String jwt;
    private String password;

    public ComandoLogin(DtoLogin dtoLogin) {
        Decodificación deco = new Decodificación(dtoLogin.getPassword());
        this.pass = deco.decodeFront();
        Decodificación decoBack = new Decodificación(this.pass);
        this.pass = decoBack.encodeBack();
        this.correo = dtoLogin.getCorreo();
    }

    @Override
    public void execute() {
        try {
            DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();
            this.usuario = daoUsuario.verificaUsuario(this.pass, this.correo);

            if(this.usuario != null) {
                String key = "oncoKey54";
                long tiempo = System.currentTimeMillis();
                DtoInfoLogin dtoInfoLogin = DtoFactory.DtoInfoLoginInstancia(
                                                            this.usuario.getCorreo(),
                                                            this.usuario.getTipoUsuario().getTipo(),
                                                            this.usuario.getNombre1(),
                                                            this.usuario.getApellido1());

                if(this.usuario.getNombre2() != null) {
                    dtoInfoLogin.setNombre2(this.usuario.getApellido2());
                }

                if(this.usuario.getApellido2() != null) {
                    dtoInfoLogin.setApellido2(this.usuario.getApellido2());
                }

                if(this.usuario.getMedico() != null) {
                    dtoInfoLogin.setMedico(this.usuario.getMedico().getId());
                } else {
                    dtoInfoLogin.setPaciente(this.usuario.getPaciente().getId());
                }

                this.jwt = Jwts.builder()
                        .signWith(SignatureAlgorithm.HS256, key)
                                    .setSubject("login")
                                    .setIssuedAt(new Date(tiempo))
                                    .setExpiration(new Date(tiempo+900000))
                                    .claim("usuario", dtoInfoLogin)
                                    .compact();
            }
        } catch(Exception ex) {
            String prueba = ex.getMessage();
        }
    }

    @Override
    public JsonObject getResult(){
        return Json.createObjectBuilder().add("JWT", this.jwt).build();
    }

}