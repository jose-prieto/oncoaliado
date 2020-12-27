package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import entidades.Cita;
import entidades.FactoryEntidades;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

public class ComandoGetCita extends ComandoBase {

    private Cita cita = FactoryEntidades.CitaInstancia();
    private long idCita;

    public ComandoGetCita(long idCita) throws Excepciones {
        if(idCita <= 0) {
            throw new Excepciones("Cita solicitada no registrada en el sistema.");
        }else {
            this.idCita = idCita;
        }
    }

    @Override
    public void execute() {
        try {
            DaoCita daoCita = DaoFactory.DaoCitaInstancia();
            this.cita = daoCita.find(this.idCita, Cita.class);
        }catch(Exception e) {
            throw e;
        }
    }

    @Override
    public Cita getResult() {
        try {
            execute();
            return this.cita;
        }catch(Exception e) {
            throw e;
        }
    }
}
