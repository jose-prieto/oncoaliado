package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Eventos.ComandoGetAllEventos;
import oncoaliado.Comandos.Eventos.ComandoLogin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/login/{password}/{user}" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class LoginApi extends AplicacionBase{

    //http://localhost:8080/Servidor/api/login/prueba/prueba
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getAllEventos(@PathParam("password") String pass, @PathParam("user") String user) {
        try {
            ComandoLogin comandoLogin = ComandoFactory.ComandoLoginInstance(pass, user);
            comandoLogin.execute();
            if (comandoLogin.getResult() != null){
                return Response.ok(comandoLogin.getResult()).build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }

}
