package oncoaliado.Comandos;

import oncoaliado.Comandos.Eventos.ComandoGetAllEventos;
import oncoaliado.Comandos.Eventos.ComandoGetEventosActivos;

public class ComandoFactory {

    public static ComandoGetAllEventos ComandoEventoInstance() {
        return new ComandoGetAllEventos();
    }

    public static ComandoGetEventosActivos ComandoEventosActivosInstance() {
        return new ComandoGetEventosActivos();
    }

}
