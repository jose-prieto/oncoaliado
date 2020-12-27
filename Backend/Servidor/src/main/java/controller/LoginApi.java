package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Ingresos.ComandoLogin;
import oncoaliado.Comandos.Ingresos.ComandoRegistroMedico;
import oncoaliado.Comandos.Ingresos.ComandoRegistroPaciente;
import transfer.DtoEspecialidadMedico;
import transfer.DtoLogin;
import transfer.DtoPaciente;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/login" )
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginApi extends AplicacionBase{

    //http://localhost:8080/Servidor/api/login
    @POST
    public Response login(DtoLogin dtoLogin) {
        try{
            ComandoLogin comandoLogin = ComandoFactory.ComandoLoginInstance(dtoLogin);
            comandoLogin.execute();
            return Response.status(Response.Status.CREATED).entity(comandoLogin.getResult()).build();
        } catch(Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    @POST
    @Path( "/registroPaciente" )
    public Response RegistroPaciente(DtoPaciente dtoPaciente) {
        try{
            ComandoRegistroPaciente comandoRegistroPaciente = ComandoFactory.ComandoRegistroPacienteInstancia(dtoPaciente);
            return Response.status(Response.Status.CREATED).entity(comandoRegistroPaciente.getResult()).build();
        } catch(Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    @POST
    @Path("/registroMedico")
    public Response RegistroMedico(DtoEspecialidadMedico dtoEspecialidadMedico) {
        try{
            ComandoRegistroMedico comandoRegistroMedico = ComandoFactory.ComandoRegistroMedicoInstancia(dtoEspecialidadMedico);
            return Response.status(Response.Status.CREATED).entity(comandoRegistroMedico.getResult()).build();
        } catch(Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

}
