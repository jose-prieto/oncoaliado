package oncoaliado.Comandos.Medicos;

import accesos.DaoFactory;
import accesos.Daos.DaoPaciente;
import entidades.FactoryEntidades;
import entidades.Paciente;
import entidades.Usuario;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import oncoaliado.Comandos.Ingresos.Decodificación;
import transfer.DtoPaciente;

public class ComandoUpdatePaciente extends ComandoBase {

    private final DtoPaciente dtoPaciente;
    private Paciente paciente;

    public ComandoUpdatePaciente(DtoPaciente dtoPaciente) throws Excepciones {
        if(dtoPaciente.getId() <= 0){
            throw new Excepciones("El id del paciente debe ser mayor a 0.");
        }else if(dtoPaciente.getUsuario() == null) {
            throw new Excepciones("El paciente debe tener un usuario registrado.");
        }else if(dtoPaciente.getUsuario().getEstado() == null) {
            throw new Excepciones("El usuario debe tener un estado de residencia.");
        }else {
            this.dtoPaciente = dtoPaciente;
        }
    }

    public void updatePaciente() throws Excepciones {
        DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
        this.paciente = daoPaciente.find(this.dtoPaciente.getId(), Paciente.class);
        if (this.paciente == null) {
            throw new Excepciones("Paciente no encontrado.");
        }else {
            if(this.dtoPaciente.getCedula() > 0) {
                this.paciente.setCedula(this.dtoPaciente.getCedula());
            }else {
                throw new Excepciones("La cédula del paciente debe ser mayor a 0.");
            }
            if(this.dtoPaciente.getEstatus() != null) {
                if(!this.dtoPaciente.getEstatus().equals("a") && !this.dtoPaciente.getEstatus().equals("i")) {
                    throw new Excepciones("Los estados posibles para el paciente son 'a' o 'i'.");
                } else {
                    this.paciente.setEstatus(this.dtoPaciente.getEstatus());
                }
            }
            daoPaciente.update(this.paciente);
        }
    }

    @Override
    public void execute() throws Excepciones {
        UpdateUsuario updateUsuario = new UpdateUsuario(this.dtoPaciente.getUsuario());
        updateUsuario.updateUsuario();
        updatePaciente();
        DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
        this.paciente = daoPaciente.find(this.dtoPaciente.getId(), Paciente.class);
        Usuario usuario = this.paciente.getUsuario();

        Decodificación decoBack = new Decodificación(this.paciente.getUsuario().getContrasena());
        Decodificación encoFront = new Decodificación(decoBack.decodeBack());
        usuario.setContrasena(encoFront.encodeFront());

        this.paciente.setUsuario(usuario);
    }

    @Override
    public Paciente getResult() throws Excepciones {
        execute();
        return this.paciente;
    }

}
