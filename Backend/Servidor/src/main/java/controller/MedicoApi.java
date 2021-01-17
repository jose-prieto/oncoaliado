package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Medicos.ComandoGetAllMedicos;
import oncoaliado.Comandos.Medicos.ComandoUpdateMedico;
import transfer.DtoEspecialidadMedico;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/medicos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class MedicoApi {

    //http://localhost:8080/Servidor/api/medicos/medicos
    @GET
    @Path("/medicos")
    public Response getAllMedicos() {
        try {
            ComandoGetAllMedicos comandoGetAllMedicos = ComandoFactory.ComandoGetAllMedicosInstance();
            comandoGetAllMedicos.execute();
            return Response.ok(comandoGetAllMedicos.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    public Response updateMedico(DtoEspecialidadMedico dtoEspecialidadMedico) {
        try {
            ComandoUpdateMedico comandoUpdateMedico = ComandoFactory.ComandoUpdateMedicoInstancia(dtoEspecialidadMedico);
            return Response.ok(comandoUpdateMedico.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }
}
