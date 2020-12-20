package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoPaciente;
import entidades.Cita;
import entidades.Paciente;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetAllCitasPaciente extends ComandoBase {

    private List<Cita> citas;
    private long id;

    public ComandoGetAllCitasPaciente(long id) {
        this.id = id;
    }

    @Override
    public void execute() {
        DaoCita dao = DaoFactory.DaoCitaInstancia();
        DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
        Paciente paciente = daoPaciente.find(this.id, Paciente.class);
        this.citas = dao.getCitasPaciente(paciente);
    }

    @Override
    public List<Cita> getResult(){
        return this.citas;
    }

}
