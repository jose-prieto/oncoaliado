package oncoaliado.Comandos.Medicos;

import accesos.DaoFactory;
import accesos.Daos.DaoEspecialidaMedico;
import accesos.Daos.DaoMedico;
import entidades.EspecialidadMedico;
import entidades.Medico;
import entidades.Usuario;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import oncoaliado.Comandos.Ingresos.Decodificación;
import transfer.DtoEspecialidadMedico;

public class ComandoUpdateMedico extends ComandoBase {

    private final DtoEspecialidadMedico dtoEspecialidadMedico;
    private EspecialidadMedico especialidadMedico;

    public ComandoUpdateMedico(DtoEspecialidadMedico dtoEspecialidadMedico) throws Excepciones {
        if(dtoEspecialidadMedico.getId() <= 0){
            throw new Excepciones("El id de la especialidad-médico debe ser mayor a 0.");
        }else if(dtoEspecialidadMedico.getMedico().getUsuario() == null) {
            throw new Excepciones("La especialidad-medico debe tener un usuario registrado.");
        }else if(dtoEspecialidadMedico.getMedico().getUsuario().getEstado() == null) {
            throw new Excepciones("El usuario debe tener un estado de residencia.");
        }else if(dtoEspecialidadMedico.getMedico() == null) {
            throw new Excepciones("La especialidad-medico debe tener un medico registrado.");
        }else {
            this.dtoEspecialidadMedico = dtoEspecialidadMedico;
        }
    }

    public void updateMedico() throws Excepciones {
        Medico medico;
        DaoMedico daoMedico = DaoFactory.DaoMedicoInstancia();
        medico = daoMedico.find(this.dtoEspecialidadMedico.getMedico().getId(), Medico.class);
        if(medico == null) {
            throw new Excepciones("El medico no fue encontrado.");
        }
        if(this.dtoEspecialidadMedico.getMedico().getEstatus() != null) {
            if(!this.dtoEspecialidadMedico.getMedico().getEstatus().equals("a") && !this.dtoEspecialidadMedico.getMedico().getEstatus().equals("i")) {
                throw new Excepciones("El estatus del medico debe ser 'a' p 'i'.");
            } else {
                medico.setEstatus(this.dtoEspecialidadMedico.getMedico().getEstatus());
            }
        }
        if(this.dtoEspecialidadMedico.getMedico().getCedula() > 0) {
            medico.setCedula(this.dtoEspecialidadMedico.getMedico().getCedula());
        } else {
            throw new Excepciones("El medico debe tener cédula mayor a 0.");
        }
        if(this.dtoEspecialidadMedico.getMedico().getDescripcion() != null) {
            medico.setDescripcion(this.dtoEspecialidadMedico.getMedico().getDescripcion());
        }
        daoMedico.update(medico);
    }

    @Override
    public void execute() throws Excepciones {
        UpdateUsuario updateUsuario = new UpdateUsuario(this.dtoEspecialidadMedico.getMedico().getUsuario());
        updateUsuario.updateUsuario();
        updateMedico();
        DaoEspecialidaMedico daoEspecialidaMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
        this.especialidadMedico = daoEspecialidaMedico.find(this.dtoEspecialidadMedico.getId(), EspecialidadMedico.class);

        Decodificación decoBack = new Decodificación(this.especialidadMedico.getMedico().getUsuario().getContrasena());
        Decodificación encoFront = new Decodificación(decoBack.decodeBack());

        Usuario usuario = this.especialidadMedico.getMedico().getUsuario();
        usuario.setContrasena(encoFront.encodeFront());

        Medico medico = this.especialidadMedico.getMedico();
        medico.setUsuario(usuario);

        this.especialidadMedico.setMedico(medico);

    }

    @Override
    public EspecialidadMedico getResult() throws Excepciones {
        execute();
        return this.especialidadMedico;
    }

}
