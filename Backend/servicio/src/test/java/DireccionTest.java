import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.entidades.Pais;

import java.util.List;


public class DireccionTest {

    @Test
    public void getDireccionTest()  throws  Exception
    {
        ucab.dsw.servicio.Direccion servicio = new ucab.dsw.servicio.Direccion();
        List<Pais> paises = servicio.getDireccion();
        Assert.assertFalse("No hay ejecuciones de encuestas",paises.isEmpty());
    }

}