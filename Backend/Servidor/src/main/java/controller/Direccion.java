package controller;

import accesos.DaoPais;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import entidades.Pais;
import java.util.List;


@Path( "/direccion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class Direccion extends AplicacionBase {

    //http://localhost:8080/Servidor/api/direccion/getDireccion
    @GET
    @Path("/getDireccion")
    @Produces("aplication/json")
    public JsonArray getDireccion() {
        JsonArrayBuilder builder = Json.createArrayBuilder();

        List<Pais> paises = null;
        try {
            DaoPais dao = new DaoPais();
            paises = dao.findAll(Pais.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        for(Pais obj: paises) {
            builder.add(Json.createObjectBuilder().add("cod_pais",obj.getId())
                    .add("nombre",obj.getNombre())
                    .add("estatus",obj.getEstatus()));
        }
        return builder.build();
    }
}