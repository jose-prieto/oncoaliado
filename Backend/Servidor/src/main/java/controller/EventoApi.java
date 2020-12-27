package controller;

import oncoaliado.Comandos.Eventos.*;
import oncoaliado.Comandos.ComandoFactory;
import transfer.DtoEvento;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author José Prieto
 * @version 1.0
 */
@Path( "/eventos" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class EventoApi extends AplicacionBase {

    /**
     * URL: http://localhost:8080/Servidor/api/eventos
     * @since 24/12/2020
     * @see ComandoGetAllEventos Lógica de la api.
     * @apiNote Api hecha para retornar todos los eventos, tanto activos como inactivos guardados en la base de datos.
     * @return Lista de objetos de tipo Evento.
     */
    @GET
    public Response getAllEventos() {
        try {
            ComandoGetAllEventos comandoGetAllEventos = ComandoFactory.ComandoEventoInstance();
            return Response.ok(comandoGetAllEventos.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/eventos/id
     * @version 1.0
     * @since 24/12/2020
     * @see ComandoGetEvento Lógica de la api.
     * @apiNote Api hecha para retornar evento del id suministrado.
     * @return Lista de objetos de tipo Evento.
     */
    @GET
    @Path("/{id}")
    public Response getEvento(@PathParam("id") long id) {
        try {
            ComandoGetEvento comandoGetEvento = ComandoFactory.ComandoGetEventoInstancia(id);
            return Response.ok(comandoGetEvento.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/eventos/EventosActivos
     * @version 1.0
     * @since 24/12/2020
     * @see ComandoGetEventosActivos Lógica de la api.
     * @apiNote Api hecha para retornar únicamente eventos activos guardados en la base de datos.
     * @return Lista de objetos de tipo Evento.
     */
    @GET
    @Path("/EventosActivos")
    public Response getEventosActivos() {
        try {
            ComandoGetEventosActivos comandoGetEventosActivos = ComandoFactory.ComandoEventosActivosInstance();
            return Response.ok(comandoGetEventosActivos.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/eventos
     * @since 24/12/2020
     * @see ComandoPostEvento Lógica de la api.
     * @apiNote Api hecha para agregar un nuevo evento a la base de datos.
     * @param evento Objeto de tipo DtoEvento.
     * @return Objeto de tipo Evento añadido.
     */
    @POST
    public Response addEvento(DtoEvento evento) {
        try {
            ComandoPostEvento comandoPostEvento = ComandoFactory.ComandoPutEventoInstancia(evento);
            return Response.ok(comandoPostEvento.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                                            .add("estado", "Excepcion")
                                            .add("excepcion",ex.getMessage())
                                            .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

    /**
     * URL: http://localhost:8080/Servidor/api/eventos/5
     * @version 1.0
     * @since 24/12/2020
     * @see ComandoUpdateEvento Lógica de la api
     * @apiNote Api para modificar información de un evento ya existente.
     * @param dtoEvento Objeto de tipo DtoEvento.
     * @return
     */
    @PUT
    public Response updateEvento(DtoEvento dtoEvento) {
        try {
            ComandoUpdateEvento comandoUpdateEvento = ComandoFactory.ComandoUpdateEventoInstance(dtoEvento);
            return Response.ok(comandoUpdateEvento.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }
}