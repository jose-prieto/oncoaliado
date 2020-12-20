package oncoaliado.Comandos.Lugares;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import entidades.Estado;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetLugares extends ComandoBase {

    private List<Estado> estados = null;

    public ComandoGetLugares() {

    }

    @Override
    public void execute() {
        DaoEstado daoEstados = DaoFactory.DaoEstadoInstancia();
        this.estados = daoEstados.findAll(Estado.class);
    }

    @Override
    public List<Estado> getResult() {
        return this.estados;
    }

}
