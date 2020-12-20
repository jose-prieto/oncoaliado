package oncoaliado.Comandos.Lugares;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoPais;
import entidades.Estado;
import entidades.Pais;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetEstados extends ComandoBase {

    private List<Estado> estados = null;
    private long idPais;

    public ComandoGetEstados(long idPais) {
        this.idPais = idPais;
    }

    @Override
    public void execute() {
        DaoEstado daoEstado = DaoFactory.DaoEstadoInstancia();
        DaoPais daoPais = DaoFactory.DaoPaisInstancia();
        Pais pais = daoPais.find(this.idPais, Pais.class);
        this.estados = daoEstado.getEstados(pais);
    }

    @Override
    public List<Estado> getResult() {
        return this.estados;
    }

}
