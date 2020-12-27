package oncoaliado.Comandos.Eventos;

import accesos.Daos.DaoEvento;
import accesos.DaoFactory;
import entidades.Evento;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 * @since 24/12/2020
 */
public class ComandoGetAllEventos extends ComandoBase {

    private List<Evento> eventos = null;

    /**
     * Método donde se buscan las todos los eventos existentes en la base de datos.
     * @see DaoEvento Data access object usado.
     * @throws Excepciones "No existen eventos en la base de datos." en caso de no encontrado ningún evento.
     */
    @Override
    public void execute() {
        try {
            DaoEvento dao = DaoFactory.DaoEventoInstancia();
            this.eventos = dao.findAll(Evento.class);
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método que retorna resultado final de los eventos encontrados.
     * @return Lista de objetos de tipo Evento
     * @see Evento
     * @throws Excepciones
     */
    @Override
    public List<Evento> getResult() {
        try {
            execute();
            return this.eventos;
        }catch(Exception e) {
            throw e;
        }
    }
}
