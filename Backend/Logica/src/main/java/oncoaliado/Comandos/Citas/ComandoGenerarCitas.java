package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoEspecialidaMedico;
import entidades.Cita;
import entidades.EspecialidadMedico;
import entidades.FactoryEntidades;
import excepciones.exceptions;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoGenerarCitas;

import java.util.GregorianCalendar;
import java.util.List;

public class ComandoGenerarCitas extends ComandoBase {

    private List<Cita> citas = null;
    private List<DtoGenerarCitas> dtoGenerarCitas;
    private long medId;

    public ComandoGenerarCitas(long id, List<DtoGenerarCitas> dtoGenerarCitas) {
        this.dtoGenerarCitas = dtoGenerarCitas;
        this.medId = id;
    }

    @Override
    public void execute() {
        try {
            for (DtoGenerarCitas obj1: this.dtoGenerarCitas) {
                GregorianCalendar horaProxima = obj1.getFecha();
                int duracion = obj1.getDuracion();
                int cantCitas = obj1.getCantCitas();

                for(int i = 0; i < cantCitas; i++) {
                    DaoCita daoCita = DaoFactory.DaoCitaInstancia();
                    Cita cita = FactoryEntidades.CitaInstancia();

                    cita.setFecha(horaProxima);
                    cita.setEstatus("inactiva");
                    cita.setPaciente(null);
                    cita.setTipoCita(null);
                    cita.setDescripcion(null);
                    cita.setFactura(null);
                    cita.setMedicoDiagnostico(null);

                    DaoEspecialidaMedico daoEspecialidadMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
                    List<EspecialidadMedico> especialidadMedico = daoEspecialidadMedico.findAll(EspecialidadMedico.class);

                    for(EspecialidadMedico obj: especialidadMedico) {
                        if (obj.getMedico().getId() == this.medId) {
                            cita.setMedico(obj);
                        }
                    }

                    daoCita.insert(cita);
                    horaProxima.add(GregorianCalendar.MINUTE, duracion);
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    @Override
    public List<Cita> getResult() throws exceptions {
        return this.citas;
    }
}
