package controller;

import oncoaliado.Comandos.Eventos.ComandoGetAllEventos;
import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Eventos.ComandoGetEventosActivos;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/eventos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EventoApi extends AplicacionBase {

    @GET
    @Path("/getAllEventos")
    public Response getAllEventos() {
        try {
            ComandoGetAllEventos comandoGetAllEventos = ComandoFactory.ComandoEventoInstance();
            comandoGetAllEventos.execute();
            return Response.ok(comandoGetAllEventos.getResult()).build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/getEventosActivos")
    public Response getEventosActivos() {
        try {
            ComandoGetEventosActivos comandoGetEventosActivos = ComandoFactory.ComandoEventosActivosInstance();
            comandoGetEventosActivos.execute();
            return Response.ok(comandoGetEventosActivos.getResult()).build();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}