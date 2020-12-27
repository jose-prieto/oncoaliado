package oncoaliado.Comandos.Eventos;

import accesos.Daos.DaoEvento;
import accesos.DaoFactory;
import entidades.Evento;
import entidades.FactoryEntidades;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoEvento;

public class ComandoPostEvento extends ComandoBase {

    private Evento evento = FactoryEntidades.EventoInstancia();
    private DtoEvento dtoEvento;

    public ComandoPostEvento(DtoEvento dtoEvento) throws Excepciones {
        try{
            if(dtoEvento == null) {
                throw new Excepciones("El objeto dtoEvento no está presente.");
            }else if(dtoEvento.getTitulo() == null) {
                throw new Excepciones("El evento debe tener un título.");
            }else if(dtoEvento.getTipo() == null) {
                throw new Excepciones("El evento debe tener un típo.");
            }else if(!dtoEvento.getTipo().equals("salud") && !dtoEvento.getTipo().equals("educativo") &&
                        !dtoEvento.getTipo().equals("otro")) {
                throw new Excepciones("Los tipos de eventos posibles son 'salud', 'educativo' y 'otro'.");
            }else if(dtoEvento.getFecha() == null) {
                throw new Excepciones("El evento debe tener una fecha.");
            }else if(dtoEvento.getEstado() == null) {
                throw new Excepciones("El evento debe tener una dirección.");
            }else {
                this.dtoEvento = dtoEvento;
            }
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void execute() throws Excepciones{
        try {
            CrearEvento crearEvento = new CrearEvento(this.dtoEvento);
            DaoEvento dao = DaoFactory.DaoEventoInstancia();
            this.evento = dao.insert(crearEvento.crearEvento());
            if (this.evento.getId() <= 0) {
                throw new Excepciones("El evento no se ingresó de manera correcta.");
            }
        } catch(Excepciones e) {
            throw e;
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public Evento getResult() throws Excepciones {
        try {
            execute();
            return this.evento;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
