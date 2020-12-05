package oncoaliado.Comandos.Eventos;

import accesos.Daos.DaoEvento;
import accesos.DaoFactory;
import entidades.Evento;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetEventosActivos extends ComandoBase {

    private List<Evento> eventos;

    public void borrarInactivos() {
        try{
            for (Evento obj: eventos) {
                if (obj.getEstatus().equals("i")) {
                    this.eventos.remove(obj);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void execute() {
        DaoEvento dao = DaoFactory.DaoEventoInstancia();
        this.eventos = dao.findAll(Evento.class);
        borrarInactivos();
    }

    @Override
    public List<Evento> getResult() {
        return eventos;
    }

}
