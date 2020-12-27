package oncoaliado.Comandos.Eventos;

import accesos.Daos.DaoEvento;
import accesos.DaoFactory;
import entidades.Evento;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 * @since 24/12/2020
 */
public class ComandoGetEventosActivos extends ComandoBase {

    private List<Evento> eventos;

    @Override
    public void execute() {
        try {
            DaoEvento dao = DaoFactory.DaoEventoInstancia();
            this.eventos = dao.eventosInactivos();
        }catch(Exception e) {
            throw e;
        }
    }

    @Override
    public List<Evento> getResult() {
        try {
            execute();
            return eventos;
        }catch(Exception e) {
            throw e;
        }
    }

}
