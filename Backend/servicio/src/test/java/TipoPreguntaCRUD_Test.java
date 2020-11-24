import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoPreguntaDto;
import ucab.dsw.entidades.TipoPregunta;

import java.util.List;


public class TipoPreguntaCRUD_Test {

    @Test
    public void addTipoPreguntaTest() throws Exception {
        ucab.dsw.servicio.TipoPreguntaCRUD servicio = new ucab.dsw.servicio.TipoPreguntaCRUD();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion( "hola" );
        tipoPreguntaDto.setEstatus( "A" );
        TipoPreguntaDto resultado = servicio.addTipoPregunta( tipoPreguntaDto );
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

    @Test
    public void getTipoPreguntaTest() throws Exception{
        ucab.dsw.servicio.TipoPreguntaCRUD servicio = new ucab.dsw.servicio.TipoPreguntaCRUD();
        List<TipoPregunta> tipoPregunta = servicio.getTipoPregunta();
        Assert.assertFalse("Error en la consulta de tipos de pregunta ",tipoPregunta.isEmpty());
    }

    /*@Test
    public void updateTipoPreguntaTest() throws Exception{
        ucab.dsw.servicio.TipoPreguntaCRUD servicio = new ucab.dsw.servicio.TipoPreguntaCRUD();
        TipoPreguntaDto tipoPreguntaDto = new TipoPreguntaDto();
        tipoPreguntaDto.setDescripcion("Seleccion Simple");
        tipoPreguntaDto.setEstatus("I");
        TipoPreguntaDto resultado = servicio.updateTipoPregunta(1, tipoPreguntaDto);
        Assert.assertNotEquals(resultado.getId(), 0);
    }

    @Test
    public void deleteTipoPreguntaTest() throws Exception{
        ucab.dsw.servicio.TipoPreguntaCRUD servicio = new ucab.dsw.servicio.TipoPreguntaCRUD();
        TipoPreguntaDto resultado = servicio.deleteTipoPregunta(1);
        Assert.assertNotEquals(resultado.getId(), 0);
    }*/
}