package oncoaliado.Comandos.Eventos;

import accesos.DaoFactory;
import accesos.Daos.DaoEvento;
import entidades.Evento;
import entidades.FactoryEntidades;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

/**
 * @author José Prieto
 * @version 1.0
 * @since 24/12/2020
 */
public class ComandoGetEvento extends ComandoBase {

    private Evento evento = FactoryEntidades.EventoInstancia();
    long id;

    /**
     * Constructor
     * @param id Objeto de tipo long con el id del evento.
     */
    public ComandoGetEvento(long id) {
        this.id = id;
    }

    /**
     * Método donde se busca evento con respecto a un id otorgado como parámetro.
     * @see DaoEvento Data access object usado.
     * @throws Excepciones "No existe el evento pedido." en caso de no encontrado ningún evento.
     */
    @Override
    public void execute() {
        try{
            DaoEvento dao = DaoFactory.DaoEventoInstancia();
            this.evento = dao.find(id, Evento.class);
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método que retorna el evento encontrado.
     * @return Objeto del tipo Evento.
     * @see Evento
     * @throws Excepciones
     */
    @Override
    public Evento getResult() {
        try{
            execute();
            return this.evento;
        }catch(Exception e){
            throw e;
        }
    }

}
