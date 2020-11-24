import org.junit.Assert;
import org.junit.Test;
import ucab.dsw.dtos.TipoUsuarioDto;
import ucab.dsw.dtos.UsuarioDto;
import ucab.dsw.entidades.Usuario;

import java.util.List;


public class pruebaORMWS_Test
{

    @Test
    public void addUserTest() throws Exception
    {
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setNombre( "Relajado" );
        usuarioDto.setApellido( "Ponce" );
        usuarioDto.setCorreoelectronico( "bismarckpm@gmail.com" );
        usuarioDto.setEstatus( "A" );
        TipoUsuarioDto tipoUsuario = new TipoUsuarioDto( 8);
        usuarioDto.setTipoUsuarioDto( tipoUsuario );
        UsuarioDto resultado = servicio.addUser( usuarioDto );
        Assert.assertNotEquals( resultado.getId(), 0  );
    }

    @Test
    public void getUserTest() throws Exception{
        ucab.dsw.servicio.pruebaORMWS servicio = new ucab.dsw.servicio.pruebaORMWS();
        List<Usuario> tipoPregunta = servicio.getUsuario();
        Assert.assertFalse("Error en la consulta de tipos de pregunta ",tipoPregunta.isEmpty());
    }


}
