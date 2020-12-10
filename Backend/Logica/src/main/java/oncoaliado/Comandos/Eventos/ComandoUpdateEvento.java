package oncoaliado.Comandos.Eventos;

import accesos.DaoFactory;
import accesos.Daos.DaoEvento;
import entidades.Estado;
import entidades.Evento;
import entidades.FactoryEntidades;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoEvento;

public class ComandoUpdateEvento extends ComandoBase {

    Evento evento;

    public ComandoUpdateEvento(DtoEvento dtoEvento, long id) {
        try {
            DaoEvento dao = new DaoEvento();
            this.evento = dao.find(id, Evento.class);

            this.evento.setTitulo(dtoEvento.getTitulo());
            this.evento.setTipo(dtoEvento.getTipo());
            this.evento.setFoto(dtoEvento.getFoto());
            this.evento.setEstatus(dtoEvento.getEstatus());
            this.evento.setDireccion(dtoEvento.getDireccion());
            this.evento.setFecha(dtoEvento.getFecha());
            this.evento.setContenido(dtoEvento.getContenido());

            Estado estado = FactoryEntidades.EstadoInstancia(dtoEvento.getEstado().getId());
            this.evento.setEstado(estado);
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void execute() {
        try {
            DaoEvento dao = DaoFactory.DaoEventoInstancia();
            this.evento = dao.update(this.evento);
        } catch(Exception ex) {
            String prueba = ex.getMessage();
        }
    }

    @Override
    public Evento getResult(){
        return this.evento;
    }
}
