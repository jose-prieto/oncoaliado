package controller;

import oncoaliado.Comandos.Factura.ComandoPagarFactura;
import oncoaliado.Comandos.ComandoFactory;
import transfer.DtoFactura;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author José Prieto
 * @version 1.0
 */
@Path("/factura")
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class FacturaApi extends AplicacionBase {

    /**
     * URL: http://localhost:8080/Servidor/api/factura
     * @since 27/12/2020
     * @see ComandoPagarFactura Lógica de la Api
     * @apiNote Api creada para poder hacer el pago automático de la factura.
     * @param dtoFactura Objeto usado para obtener los datos necesarios de la factura.
     * @return Objeto Factura
     */
    @PUT
    public Response pagarCita(DtoFactura dtoFactura) {
        try {
            ComandoPagarFactura comandoPagarFactura = ComandoFactory.ComandoPagarFacturaInstancia(dtoFactura);
            return Response.ok(comandoPagarFactura.getResult()).build();
        } catch (Exception ex) {
            JsonObject data = Json.createObjectBuilder()
                    .add("estado", "Excepcion")
                    .add("excepcion",ex.getMessage())
                    .add("codigo", 500).build();
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(data).build();
        }
    }

}
