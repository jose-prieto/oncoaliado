import controller.EventoApi;

import org.junit.Assert;
import org.junit.Test;
import javax.ws.rs.core.Response;


public class EventoTest {

    @Test
    public void getEventosTest()  throws  Exception
    {
        EventoApi servicio = new EventoApi();
        Response eventos = servicio.getAllEventos();
        System.out.println(eventos);
        Assert.assertEquals(200,200);
    }

}