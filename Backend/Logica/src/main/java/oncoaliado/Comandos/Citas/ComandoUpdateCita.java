package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoEspecialidaMedico;
import accesos.Daos.DaoPaciente;
import accesos.Daos.DaoTipoCita;
import entidades.*;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoCita;
import transfer.DtoFactory;

public class ComandoUpdateCita extends ComandoBase {

    private Cita cita = FactoryEntidades.CitaInstancia();
    private DtoCita dtoCita = DtoFactory.DtoCitaInstancia();
    private DaoCita daoCita = DaoFactory.DaoCitaInstancia();

    public ComandoUpdateCita(DtoCita dtoCita) {
        this.dtoCita = dtoCita;
    }

    public void execute() {
        try{
            this.cita = this.daoCita.find(dtoCita.getId(), Cita.class);

            this.cita.setEstatus(this.dtoCita.getEstatus());
            this.cita.setFecha(this.dtoCita.getFecha());
            this.cita.setDescripcion(this.dtoCita.getDescripcion());

            DaoEspecialidaMedico daoMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
            if(dtoCita.getMedico() != null) {
                this.cita.setMedico(daoMedico.find(this.dtoCita.getMedico().getId(), EspecialidadMedico.class));
            }

            if(dtoCita.getMedicoDiagnostico() != null) {
                this.cita.setMedicoDiagnostico(daoMedico.find(this.dtoCita.getMedicoDiagnostico().getId(), EspecialidadMedico.class));
            }

            DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
            if(dtoCita.getPaciente() != null) {
                this.cita.setPaciente(daoPaciente.find(this.dtoCita.getPaciente().getId(), Paciente.class));
            }

            DaoTipoCita daoTipoCita = DaoFactory.DaoTipoCitaInstancia();
            if(dtoCita.getTipoCita() != null) {
                this.cita.setTipoCita(daoTipoCita.find(dtoCita.getTipoCita().getId(), TipoCita.class));
            }

        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public Cita getResult() {
        return daoCita.update(this.cita);
    }

}
