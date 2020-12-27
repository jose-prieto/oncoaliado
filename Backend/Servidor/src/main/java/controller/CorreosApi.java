package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Correos.ComandoCorreo;
import transfer.DtoCorreo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/correo")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class CorreosApi extends AplicacionBase {

    @POST
    public Response CorreoPregunta(DtoCorreo dtoCorreo) {
        try {
            ComandoCorreo comandoCorreo = ComandoFactory.ComandoCorreoPreguntaInstancia(dtoCorreo);
            comandoCorreo.execute();
            return Response.ok().build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex).build();
        }
    }

}
