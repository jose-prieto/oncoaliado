package oncoaliado.Comandos;

import oncoaliado.Comandos.Eventos.*;
import oncoaliado.Comandos.Medicos.ComandoGetAllMedicos;
import transfer.DtoEvento;

public class ComandoFactory {

    public static ComandoGetAllEventos ComandoEventoInstance() {
        return new ComandoGetAllEventos();
    }

    public static ComandoGetEventosActivos ComandoEventosActivosInstance() {
        return new ComandoGetEventosActivos();
    }

    public static ComandoPutEvento ComandoPutEventoInstancia(DtoEvento dtoEvento) {
        return new ComandoPutEvento(dtoEvento);
    }

    public static ComandoGetAllMedicos ComandoGetAllMedicosInstance() {
        return new ComandoGetAllMedicos();
    }

    public static ComandoUpdateEvento ComandoUpdateEventoInstance(DtoEvento evento, long id) {
        return new ComandoUpdateEvento(evento, id);
    }

    public static ComandoLogin ComandoLoginInstance(String pass, String user) {
        return new ComandoLogin(pass, user);
    }

}
