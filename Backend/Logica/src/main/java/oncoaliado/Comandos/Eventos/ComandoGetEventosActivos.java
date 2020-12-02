package oncoaliado.Comandos.Eventos;

import accesos.DaoEstado;
import accesos.DaoEvento;
import accesos.DaoFactory;
import accesos.DaoPais;
import entidades.Estado;
import entidades.Evento;
import entidades.FactoryEntidades;
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
        DaoEvento dao = DaoFactory.DaoEventoInstance();
        this.eventos = dao.findAll(Evento.class);
        borrarInactivos();
    }

    @Override
    public List<Evento> getResult() {
        return eventos;
    }

}
