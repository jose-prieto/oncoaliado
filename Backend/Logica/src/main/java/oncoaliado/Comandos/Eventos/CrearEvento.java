package oncoaliado.Comandos.Eventos;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoEvento;
import entidades.Estado;
import entidades.Evento;
import entidades.FactoryEntidades;
import excepciones.Excepciones;
import transfer.DtoEvento;

/**
 * @author José Prieto
 * @since 24/12/2020
 * @version 1.0
 */
public class CrearEvento {

    private DtoEvento dtoEvento;
    private Evento evento = FactoryEntidades.EventoInstancia();

    /**
     * Constructor de la clase.
     * @param dtoEvento objeto del tipo DtoEvento.
     * @see DtoEvento
     * @throws Excepciones Validador de que los datos del DtoEvento sean correctos para su utilización.
     */
    public CrearEvento(DtoEvento dtoEvento) throws Excepciones{
        try {
            if(dtoEvento == null) {
                throw new Excepciones("El dto del evento debe estar presente.");
            }else if(dtoEvento.getEstado() == null) {
                throw new Excepciones("El evento debe tener una dirección.");
            } else if(dtoEvento.getTitulo() == null) {
                throw new Excepciones("El evento debe tener un titulo.");
            } else if(dtoEvento.getFecha() == null) {
                throw new Excepciones("El evento debe tener una fecha");
            } else if(dtoEvento.getTipo() == null ) {
                throw new Excepciones("El evento debe tener un tipo");
            } else if(!dtoEvento.getTipo().equals("salud") && !dtoEvento.getTipo().equals("educativo") && !dtoEvento.getTipo().equals("otro")) {
                throw new Excepciones("El evento debe ser de tipo 'salud','educativo' u 'otro'");
            }

            this.dtoEvento = dtoEvento;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de armar el objeto de tipo Evento para su próxima actualización o inserción en la base de datos.
     * @return Objeto del tipo Evento.
     * @see Evento
     * @throws Excepciones "Estado no encontrado en la base de datos." en caso de que el estado proporcionado no exista en la base de datos.
     */
    public Evento crearEvento() throws Excepciones{
        try{
            this.evento.setTitulo(this.dtoEvento.getTitulo());
            this.evento.setTipo(this.dtoEvento.getTipo());
            this.evento.setFoto(this.dtoEvento.getFoto());
            this.evento.setEstatus("a");
            this.evento.setDireccion(this.dtoEvento.getDireccion());
            this.evento.setFecha(this.dtoEvento.getFecha());
            this.evento.setContenido(this.dtoEvento.getContenido());

            DaoEstado daoEstado = DaoFactory.DaoEstadoInstancia();
            this.evento.setEstado(daoEstado.find(this.dtoEvento.getEstado().getId(), Estado.class));
            if (this.evento.getEstado() == null) {
                throw new Excepciones("Estado no encontrado en la base de datos.");
            }
            return this.evento;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    public Evento updateEvento() throws Excepciones {
        try{
            DaoEvento daoEvento = DaoFactory.DaoEventoInstancia();
            this.evento = daoEvento.find(this.dtoEvento.getId(), Evento.class);
            crearEvento();
            if(!dtoEvento.getEstatus().equals("a") && !dtoEvento.getEstatus().equals("i")) {
                throw new Excepciones("Los estados posibles para el evento son 'a' e 'i'.");
            }
            this.evento.setEstatus(dtoEvento.getEstatus());
            return this.evento;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
