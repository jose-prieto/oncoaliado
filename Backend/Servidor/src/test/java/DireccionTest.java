import controller.Direccion;
import org.junit.Assert;
import org.junit.Test;
import entidades.Pais;

import java.util.List;


public class DireccionTest {

    @Test
    public void getDireccionTest()  throws  Exception
    {
        Direccion servicio = new Direccion();
        List<Pais> paises = servicio.getDireccion();
        Assert.assertFalse("No hay ejecuciones de encuestas",paises.isEmpty());
    }

}