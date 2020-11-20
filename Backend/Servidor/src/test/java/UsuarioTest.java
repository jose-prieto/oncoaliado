import org.junit.Assert;
import org.junit.Test;
import transfer.DtoDireccion;


public class UsuarioTest {

    @Test
    public void addPaisTest() {
        controller.Prueba servicio = new controller.Prueba();
        DtoDireccion direccionDto = new DtoDireccion();
        direccionDto.setNombre( "venezuela" );
        DtoDireccion resultado = servicio.addPais(direccionDto);
        Assert.assertNotEquals( resultado.getId(), 0 );
    }

}