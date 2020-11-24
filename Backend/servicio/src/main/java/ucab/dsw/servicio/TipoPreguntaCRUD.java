package ucab.dsw.servicio;

import ucab.dsw.accesodatos.DaoTipoPregunta;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import java.util.List;


@Path( "/PreguntaCRUD" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class TipoPreguntaCRUD extends AplicacionBase {

    @PUT
    @Path( "/addtipopregunta" )
    public TipoPreguntaDto addTipoPregunta(TipoPreguntaDto tipoPreguntaDto)
    {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = new TipoPregunta();
            tipoPregunta.set_descripcion( tipoPreguntaDto.getDescripcion() );
            tipoPregunta.set_estatus( tipoPreguntaDto.getEstatus() );
            TipoPregunta resul = dao.insert( tipoPregunta );
            resultado.setId( resul.get_id() );
        }
        catch ( Exception ex )
        {
            String problema = ex.getMessage();
        }
        return  resultado;
    }


    @GET
    @Path("/getTipoPregunta")
    public List<TipoPregunta> getTipoPregunta() {

        List<TipoPregunta> tipoPreguntas = null;
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            tipoPreguntas = dao.findAll(TipoPregunta.class);
        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        for (TipoPregunta obj : tipoPreguntas){
            System.out.println(obj.get_descripcion());
        }
        return tipoPreguntas;
    }


    /*@PUT
    @Path("/updateTipoPregunta/{id}")
    public TipoPreguntaDto updateTipoPregunta(@PathParam("id") long id, TipoPreguntaDto tipoPreguntaDto) {
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);
            tipoPregunta.set_descripcion(tipoPreguntaDto.getDescripcion());
            tipoPregunta.set_estatus(tipoPreguntaDto.getEstatus());
            TipoPregunta resul = dao.update(tipoPregunta);
            resultado.setId(resul.get_id());

        } catch (Exception ex) {
            String problema = ex.getMessage();
        }
        return resultado;
    }


    @DELETE
    @Path("/deleteTipoPregunta/{id}")
    public TipoPreguntaDto deleteTipoPregunta(@PathParam("id") long id){
        TipoPreguntaDto resultado = new TipoPreguntaDto();
        try
        {
            DaoTipoPregunta dao = new DaoTipoPregunta();
            TipoPregunta tipoPregunta = dao.find(id, TipoPregunta.class);
            if (tipoPregunta != null) {
                TipoPregunta resul = dao.delete(tipoPregunta);
                resultado.setId(resul.get_id());
            }
        }
        catch (Exception ex){
            String problema = ex.getMessage();
        }
        return resultado;
    }*/
}