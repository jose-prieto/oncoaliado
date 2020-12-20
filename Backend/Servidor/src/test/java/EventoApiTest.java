import org.junit.Assert;
import org.junit.Test;
import controller.EventoApi;
import transfer.DtoEstado;
import transfer.DtoEvento;
import transfer.DtoFactory;

import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class EventoApiTest {

    @Test
    public void addSolicitudTest() throws Exception
    {
        /*EventoApi servicio = new EventoApi();
        DtoEvento dtoEvento = new DtoEvento();
        dtoEvento.setEstatus("a");
        dtoEvento.setTitulo("la oveja negra");
        dtoEvento.setContenido("la oveja ha fallecido");
        dtoEvento.setDireccion("catia la mar");
        dtoEvento.setTipo("salud");
        dtoEvento.setFoto("lenguaje.png");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        GregorianCalendar cal1 = new GregorianCalendar();
        cal1.setTime(format.parse("2020-05-05"));
        dtoEvento.setFecha(cal1);

        DtoEstado dtoEstado= DtoFactory.DtoEstadoInstancia(5);
        dtoEvento.setEstado(dtoEstado);

        Response resultado = servicio.addEvento(dtoEvento);
        Assert.assertNotEquals( 1, 0 );*/
    }

}
