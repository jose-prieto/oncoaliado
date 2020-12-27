package oncoaliado.Comandos.Ingresos;

import accesos.DaoFactory;
import accesos.Daos.DaoEstado;
import accesos.Daos.DaoPaciente;
import accesos.Daos.DaoTipoUsuario;
import accesos.Daos.DaoUsuario;
import entidades.*;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoPaciente;
import transfer.DtoUsuario;

import javax.persistence.PersistenceException;

public class ComandoRegistroPaciente extends ComandoBase {

    private Paciente paciente = FactoryEntidades.PacienteInstancia();
    private Usuario usuario = FactoryEntidades.UsuarioInstancia();
    private DtoUsuario dtoUsuario;
    private DtoPaciente dtoPaciente;

    public ComandoRegistroPaciente(DtoPaciente dtoPaciente) throws Excepciones{
        try {
            if(dtoPaciente == null) {
                throw new Excepciones("El paciente no debe ser null.");
            }else if(dtoPaciente.getUsuario() == null) {
                throw new Excepciones("El usuario del paciente no debe ser null.");
            } else {
                this.dtoUsuario = dtoPaciente.getUsuario();
                this.dtoPaciente = dtoPaciente;
            }
        }catch (Excepciones e) {
            throw e;
        }catch (Exception e) {
            throw e;
        }

    }

    public void addPaciente() throws Excepciones{
        try {
            AddUsuario addUsuario = new AddUsuario();
            this.usuario = addUsuario.addUsuario(this.dtoUsuario);
            DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();

            if (this.dtoPaciente.getCedula() <= 0){
                daoUsuario.delete(daoUsuario.find(this.usuario.getId(), Usuario.class));
                throw new Excepciones("El campo cédula debe estar lleno y debe ser mayor a 0.");
            }
            this.paciente.setUsuario(this.usuario);
            this.paciente.setEstatus("a");
            this.paciente.setCedula(this.dtoPaciente.getCedula());

            DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
            this.paciente = daoPaciente.insert(this.paciente);
            if (this.paciente == null) {
                daoUsuario.delete(this.usuario);
                throw new Excepciones("El paciente no fue agregado de manera correcta.");
            }
        }catch(Excepciones e) {
            throw e;
        }catch(PersistenceException e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    @Override
    public void execute() throws Excepciones {
        try {
            addPaciente();
        } catch(Excepciones e) {
            throw e;
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public Paciente getResult() throws Excepciones{
        try {
            execute();
            return this.paciente;
        }catch(PersistenceException e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
