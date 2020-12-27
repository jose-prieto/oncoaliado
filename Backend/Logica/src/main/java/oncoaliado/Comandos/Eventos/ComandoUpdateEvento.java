package oncoaliado.Comandos.Eventos;

import accesos.DaoFactory;
import accesos.Daos.DaoEvento;
import entidades.Estado;
import entidades.Evento;
import entidades.FactoryEntidades;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoEvento;

public class ComandoUpdateEvento extends ComandoBase {

    private Evento evento;
    private DtoEvento dtoEvento;

    public ComandoUpdateEvento(DtoEvento dtoEvento) throws Excepciones {
        try{
            if(dtoEvento == null) {
                throw new Excepciones("El objeto dtoEvento no está presente.");
            }else if(dtoEvento.getId() <= 0){
                throw new Excepciones("El objeto debe tener un id mayor o igual a 0.");
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
            DaoEvento daoEvento = DaoFactory.DaoEventoInstancia();
            this.evento = crearEvento.updateEvento();
            this.evento = daoEvento.update(this.evento);
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
