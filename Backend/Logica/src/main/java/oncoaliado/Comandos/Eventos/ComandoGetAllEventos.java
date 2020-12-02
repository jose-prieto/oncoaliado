package oncoaliado.Comandos.Eventos;

import accesos.DaoEvento;
import accesos.DaoFactory;
import entidades.Evento;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetAllEventos extends ComandoBase {

    private List<Evento> eventos;

    @Override
    public void execute() {
        DaoEvento dao = DaoFactory.DaoEventoInstance();
        this.eventos = dao.findAll(Evento.class);
    }

    @Override
    public List<Evento> getResult() {
        return eventos;
    }
}
