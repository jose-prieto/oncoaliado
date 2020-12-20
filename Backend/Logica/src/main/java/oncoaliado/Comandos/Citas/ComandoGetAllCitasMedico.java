package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import entidades.Cita;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetAllCitasMedico extends ComandoBase {

    private List<Cita> citas;
    private long id;

    public ComandoGetAllCitasMedico(long id) {
        this.id = id;
        DaoCita dao = DaoFactory.DaoCitaInstancia();
        this.citas = dao.findAll(Cita.class);
    }

    @Override
    public void execute() {
        for (Cita obj: this.citas) {
            if(obj.getMedico().getMedico().getId() != this.id) {
                this.citas.remove(obj);
            }
        }
    }

    @Override
    public List<Cita> getResult(){
        return this.citas;
    }

}
