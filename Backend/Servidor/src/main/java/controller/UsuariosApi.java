package controller;

import entidades.Paciente;
import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Medicos.ComandoUpdateMedico;
import oncoaliado.Comandos.Medicos.ComandoUpdatePaciente;
import oncoaliado.Comandos.Usuarios.ComandoGetMedico;
import oncoaliado.Comandos.Usuarios.ComandoGetPaciente;
import transfer.DtoEspecialidadMedico;
import transfer.DtoPaciente;
import transfer.DtoUsuarioCorreo;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UsuariosApi extends AplicacionBase {


    @POST
    public Response getUsuario(DtoUsuarioCorreo dtoUsuarioCorreo) {
        try {
            ComandoGetPaciente comandoGetPaciente = ComandoFactory.ComandoGetPacienteInstancia(dtoUsuarioCorreo);
            Paciente paciente = comandoGetPaciente.getResult();
            if (paciente != null) {
                return Response.ok(comandoGetPaciente.getResult()).build();
            } else {
                ComandoGetMedico comandoGetMedico = ComandoFactory.ComandoGetMedicoInstancia(dtoUsuarioCorreo);
                return Response.ok(comandoGetMedico.getResult()).build();
            }
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    @PUT
    public Response updatePaciente(DtoPaciente dtoPaciente) {
        try {
            ComandoUpdatePaciente comandoUpdatePaciente = ComandoFactory.ComandoUpdatePacienteInstancia(dtoPaciente);
            return Response.ok(comandoUpdatePaciente.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

}
