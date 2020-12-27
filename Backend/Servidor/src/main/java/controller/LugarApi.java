package controller;

import oncoaliado.Comandos.ComandoFactory;
import oncoaliado.Comandos.Lugares.ComandoGetEstados;
import oncoaliado.Comandos.Lugares.ComandoGetLugares;
import oncoaliado.Comandos.Lugares.ComandoGetPaises;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lugares")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class LugarApi extends AplicacionBase {

    @GET
    public Response getLugares() {
        try {
            ComandoGetLugares comandoGetLugares = ComandoFactory.ComandoGetLugaresInstancia();
            comandoGetLugares.execute();
            return Response.ok(comandoGetLugares.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/paises")
    public Response getPaises() {
        try {
            ComandoGetPaises comandoGetPaises = ComandoFactory.ComandoGetPaisesInstancia();
            comandoGetPaises.execute();
            return Response.ok(comandoGetPaises.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/estados/{id}")
    public Response getEstados(@PathParam("id") long id) {
        try {
            ComandoGetEstados comandoGetEstados = ComandoFactory.ComandoGetEstadosInstancia(id);
            comandoGetEstados.execute();
            return Response.ok(comandoGetEstados.getResult()).build();
        } catch (Exception ex) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
