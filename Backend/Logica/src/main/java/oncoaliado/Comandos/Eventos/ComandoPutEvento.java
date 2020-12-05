package oncoaliado.Comandos.Eventos;

import accesos.Daos.DaoEvento;
import accesos.DaoFactory;
import entidades.Estado;
import entidades.Evento;
import entidades.FactoryEntidades;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoEvento;
import transfer.DtoFactory;

public class ComandoPutEvento extends ComandoBase {

    private Evento evento = FactoryEntidades.EventoInstancia();
    private Evento eventoInicial = FactoryEntidades.EventoInstancia();
    private DtoEvento resultado = DtoFactory.DtoEventoInstancia();

    public ComandoPutEvento (DtoEvento dtoEvento) {
        try {

            this.evento.setEstatus(dtoEvento.getEstatus());
            this.evento.setContenido(dtoEvento.getContenido());
            this.evento.setDireccion(dtoEvento.getDireccion());
            this.evento.setFecha(dtoEvento.getFecha());

            this.evento.setFoto(dtoEvento.getFoto());
            this.evento.setTipo(dtoEvento.getTipo());
            this.evento.setTitulo(dtoEvento.getTitulo());

            Estado estado = FactoryEntidades.EstadoInstancia(dtoEvento.getEstado().getId());
            this.evento.setEstado(estado);

        } catch (Exception ex){
            String prueba = ex.getMessage();
        }
    }

    @Override
    public void execute() {
        try {
            DaoEvento dao = DaoFactory.DaoEventoInstancia();
            this.eventoInicial = this.evento;
            this.evento = dao.insert(this.evento);
            this.resultado.setId(evento.getId());
        } catch(Exception ex) {
            String prueba = ex.getMessage();
        }
    }

    @Override
    public Evento getResult(){
        return this.eventoInicial;
    }

}
