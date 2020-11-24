package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoPais;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ucab.dsw.entidades.Pais;
import java.util.List;


@Path( "/direccion" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class Direccion extends AplicacionBase {

    @GET
    @Path("/getDireccion")
    public List<Pais> getDireccion() {

        List<Pais> paises = null;
        try {
            DaoPais dao = new DaoPais();
            paises = dao.findAll(Pais.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (Pais obj : paises) {
            System.out.println(obj.getNombre());
        }
        return paises;
    }
}