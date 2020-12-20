package oncoaliado.Comandos.Lugares;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoPais;
import entidades.Estado;
import entidades.Pais;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetPaises extends ComandoBase {

    private List<Pais> paises = null;

    public ComandoGetPaises() {

    }

    @Override
    public void execute() {
        DaoPais daoPaises = DaoFactory.DaoPaisInstancia();
        this.paises = daoPaises.findAll(Pais.class);
    }

    @Override
    public List<Pais> getResult() {
        return this.paises;
    }

}
