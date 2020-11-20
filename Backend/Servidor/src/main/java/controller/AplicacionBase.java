package controller;

import accesos.DaoPais;
import entidades.PAIS;
import transfer.DtoDireccion;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@ApplicationPath( "/api" )
@Path("/usuario")
public class AplicacionBase extends Application {

    //http://localhost:8080/Servidor-1.0/api/usuario/direccion
    @GET
    @Path("/direccion")
    @Produces("application/json")
    public String getMessage(){
        return "hola como estas";
    }

    /*@GET
    @Path("/direccion")
    @Produces("/direccion/json")
    public DtoDireccion addPais(DtoDireccion direccion )
    {
        DtoDireccion resultado = new DtoDireccion();
        try
        {
            DaoPais dao = new DaoPais();
            PAIS pais = new PAIS();
            pais.setNombre(direccion.getNombre());
            PAIS resul = dao.insert(pais);
            resultado.setId(resul.get_id());

        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }*/
}
