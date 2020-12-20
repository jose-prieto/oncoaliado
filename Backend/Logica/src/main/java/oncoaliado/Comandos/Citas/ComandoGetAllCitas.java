package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import entidades.Cita;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetAllCitas extends ComandoBase {

    private List<Cita> citas = null;

    @Override
    public void execute() {
        DaoCita daoCita = DaoFactory.DaoCitaInstancia();
        this.citas = daoCita.findAll(Cita.class);
    }

    @Override
    public List<Cita> getResult() {
        return this.citas;
    }

}
