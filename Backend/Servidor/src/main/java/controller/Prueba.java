package controller;

import accesos.DaoPais;
import transfer.DtoDireccion;
import entidades.PAIS;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path( "/prueba" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class Prueba extends AplicacionBase {

    @PUT
    @Path( "/addpais" )
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
    }

    @GET
    @Path( "/prueba2" )
    public String consulta()
    {
        return "Epa";
    }
}