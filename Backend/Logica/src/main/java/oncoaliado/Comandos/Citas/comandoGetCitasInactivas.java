package oncoaliado.Comandos.Citas;

import entidades.Cita;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class comandoGetCitasInactivas extends ComandoBase {

    private List<Cita> citas;
    private long idMed;

    public comandoGetCitasInactivas(long idMed) {
        this.idMed = idMed;
    }

    @Override
    public void execute() {

    }

    @Override
    public List<Cita> getResult(){
        return this.citas;
    }

}
