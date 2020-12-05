package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Medicos.ComandoGetAllMedicos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/medicos" )
public class MedicoApi {

    //http://localhost:8080/Servidor/api/medicos/medicos
    @GET
    @Path("/medicos")
    @Produces( MediaType.APPLICATION_JSON )
    public Response getAllMedicos() {
        try {
            ComandoGetAllMedicos comandoGetAllMedicos = ComandoFactory.ComandoGetAllMedicosInstance();
            comandoGetAllMedicos.execute();
            return Response.ok(comandoGetAllMedicos.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
