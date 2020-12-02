import controller.Direccion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.json.JsonArray;


public class DireccionTest {

    @Before
    public void primero() {
        System.out.println("hola");
    }

    @Test
    public void getDireccionTest()  throws  Exception
    {
        Direccion servicio = new Direccion();
        JsonArray paises = servicio.getDireccion();
        System.out.println(paises);
        Assert.assertFalse("No hay ejecuciones de encuestas",paises.isEmpty());
    }

}