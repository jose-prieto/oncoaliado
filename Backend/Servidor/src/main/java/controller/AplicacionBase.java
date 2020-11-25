package controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@ApplicationPath( "/api" )
public class AplicacionBase extends Application {

    /*//http://localhost:8080/Servidor/api/usuario/direccion
    @GET
    @Path("/direccion")
    @Produces("application/json")
    public String getMessage(){
        return "hola como estas";
    }

    @GET
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
