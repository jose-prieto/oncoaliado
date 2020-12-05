package controller;

import oncoaliado.Comandos.Eventos.ComandoGetAllEventos;
import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Eventos.ComandoGetEventosActivos;
import oncoaliado.Comandos.Eventos.ComandoPutEvento;
import transfer.DtoEvento;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/eventos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EventoApi extends AplicacionBase {

    //http://localhost:8080/Servidor/api/eventos/Eventos
    @GET
    @Path("/Eventos")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getAllEventos() {
        try {
            ComandoGetAllEventos comandoGetAllEventos = ComandoFactory.ComandoEventoInstance();
            comandoGetAllEventos.execute();
            return Response.ok(comandoGetAllEventos.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //http://localhost:8080/Servidor/api/eventos/EventosActivos
    @GET
    @Path("/EventosActivos")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response getEventosActivos() {
        try {
            ComandoGetEventosActivos comandoGetEventosActivos = ComandoFactory.ComandoEventosActivosInstance();
            comandoGetEventosActivos.execute();
            return Response.ok(comandoGetEventosActivos.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //http://localhost:8080/Servidor/api/eventos/Evento
    @POST
    @Path("/Evento")
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public Response addEvento(DtoEvento evento) {
        try {
            ComandoPutEvento comandoPutEvento = ComandoFactory.ComandoPutEventoInstancia(evento);
            comandoPutEvento.execute();
            return Response.ok(comandoPutEvento.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }
    }
}