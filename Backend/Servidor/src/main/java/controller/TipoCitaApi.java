package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.TipoCita.ComandoGetTipoCitas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/tipoCitas")
public class TipoCitaApi extends AplicacionBase {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLugares() {
        try {
            ComandoGetTipoCitas comandoGetTipoCitas = ComandoFactory.ComandoGetTipoCitasInstancia();
            comandoGetTipoCitas.execute();
            return Response.ok(comandoGetTipoCitas.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
