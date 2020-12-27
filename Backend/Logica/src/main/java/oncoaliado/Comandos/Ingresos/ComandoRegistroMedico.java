package oncoaliado.Comandos.Ingresos;

import accesos.DaoFactory;
import accesos.Daos.*;
import entidades.*;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.*;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoRegistroMedico extends ComandoBase {

    private final DtoEspecialidadMedico dtoEspecialidadMedico;
    private final DaoUsuario daoUsuario = DaoFactory.DaoUsuarioInstancia();
    private final DaoMedico daoMedico = DaoFactory.DaoMedicoInstancia();
    private final DaoEspecialidad daoEspecialidad = DaoFactory.DaoEspecialidadInstancia();
    private final DtoMedico dtoMedico;
    private final DtoEspecialidad dtoEspecialidad;
    private final DtoUsuario dtoUsuario;
    private EspecialidadMedico especialidadMedico = FactoryEntidades.EspecialidadMedicoInstancia();
    private Usuario usuario;
    private Medico medico = FactoryEntidades.MedicoInstancia();
    private Especialidad especialidad;

    /**
     * constructor de la clase
     * @since 26/12/2020
     * @param dtoEspecialidadMedico Variable usada para obtenet los datos del médico.
     * @see DtoEspecialidadMedico Data transfer object usado para obtener los datos del médico a registrar.
     * @throws Excepciones Retorna excepcrón en caso de que alguno de los datos sea inválido.
     */
    public ComandoRegistroMedico(DtoEspecialidadMedico dtoEspecialidadMedico) throws Excepciones {
        if (dtoEspecialidadMedico == null) {
            throw new Excepciones("La especialidad_medico no debe ser null.");
        } else if(dtoEspecialidadMedico.getMedico() == null) {
            throw new Excepciones("El medico de la especialidad_medico no debe ser null.");
        } else if(dtoEspecialidadMedico.getMedico().getUsuario() == null) {
            throw new Excepciones("El usuario del médico no debe ser null");
        } else {
            this.dtoEspecialidadMedico = dtoEspecialidadMedico;
            this.dtoMedico = dtoEspecialidadMedico.getMedico();
            this.dtoEspecialidad = dtoEspecialidadMedico.getEspecialidad();
            this.dtoUsuario = dtoEspecialidadMedico.getMedico().getUsuario();
        }
    }

    /**
     * Método usado para ingresar los datos correspondientes a la tabla médico
     * @since 26/12/2020
     * @see AddUsuario Clase donde se encuentra la lógica para agregar al usuario del médico.
     * @see DtoMedico Data transfer object usado para poder obtener los datos del médico.
     * @see Medico Entidad persistente usada para registrar al usuario.
     * @see DaoMedico Data access object usado para registrar al médico.
     * @throws Excepciones Lanza excepción en caso de que el haya algún problema con la cédula del médico o por alguna
     * razón el mismo no se haya podido registrar de manera correcta.
     */
    private void addMedico() throws Excepciones {
        AddUsuario addUsuario = new AddUsuario();
        this.usuario = addUsuario.addUsuario(this.dtoUsuario);

        if (this.dtoMedico.getCedula() <= 0) {
            this.daoUsuario.delete(this.usuario);
            throw new Excepciones("El campo cédula debe estar lleno y debe ser mayor a 0.");
        }
        DaoMedico daoMedico = DaoFactory.DaoMedicoInstancia();

        this.medico.setUsuario(this.usuario);
        this.medico.setCedula(this.dtoEspecialidadMedico.getMedico().getCedula());
        this.medico.setEstatus("a");
        this.medico.setDescripcion(this.dtoEspecialidadMedico.getMedico().getDescripcion());

        this.medico = daoMedico.insert(medico);
        if(this.medico.getId() == 0) {
            this.daoUsuario.delete(this.usuario);
            throw new Excepciones("El médico no fue agregado de manera correcta.");
        }
    }

    /**
     * Método encargado de añadir una especialidad.
     * @see DtoEspecialidad Data transfer object usado para obtener la especialidad a asociar con el médico.
     * @see DaoEspecialidad Data access object usada para asociar al medico con su especialidad.
     * @see Especialidad Entidad persistente usada para almacenar la especialidad en cache.
     * @throws Excepciones Lanza excepción en caso de que la especialidad no se agregue de manera correcta.
     */
    private void addEspecialidad() throws Excepciones{
        if(this.dtoEspecialidad.getId() <= 0) {
            this.daoMedico.delete(this.medico);
            this.daoUsuario.delete(this.usuario);
            throw new Excepciones("El id de la especialidad debe ser mayor a 0.");
        }

        this.especialidad = this.daoEspecialidad.find(dtoEspecialidad.getId(), Especialidad.class);
        if(this.especialidad.getId() <= 0) {
            this.daoMedico.delete(this.medico);
            this.daoUsuario.delete(this.usuario);
            throw new Excepciones("La especialidad no se pudo agregar de manera correcta.");
        }
    }

    /**
     * Método encargado de añadir el registro en especialidad médico con todos sus atributos.
     * @see EspecialidadMedico Entidad persistente usada para Retornar la información recién insertada.
     * @see DaoEspecialidaMedico Data access object usado para insertar la nueva especialidadMedico.
     * @throws Excepciones Lanza excepción en caso de que la especialidadMedico no se haya insertado de manera correcta.
     */
    public void addEspecialidadMedico() throws Excepciones {
        addMedico();
        addEspecialidad();

        this.especialidadMedico.setEstatus("a");
        this.especialidadMedico.setMedico(this.medico);
        this.especialidadMedico.setEspecialidad(this.especialidad);

        DaoEspecialidaMedico daoEspecialidaMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
        this.especialidadMedico = daoEspecialidaMedico.insert(this.especialidadMedico);
        if (this.especialidadMedico.getId() == 0) {
            this.daoMedico.delete(this.medico);
            this.daoUsuario.delete(this.usuario);
            throw new Excepciones("La especialidad_medico no fue agregada de manera correcta.");
        }
    }

    /**
     * Método usado para correr la secuencia de métodos.
     * @throws Excepciones relanza excepciones obtenida en métodos anteriores.
     */
    @Override
    public void execute() throws Excepciones {
        addEspecialidadMedico();
    }

    /**
     * Método usado para retornar los datos de la EspecialidadMedico insertados en el sistema.
     * @return Objeto de tipo EspecialidadMedico
     * @see EspecialidadMedico Entidad persistente usada para retornar los datos insertados en el sistema.
     * @throws Excepciones relanza excepciones obtenidas en métodos anteriores.
     */
    @Override
    public EspecialidadMedico getResult() throws Excepciones{
        execute();
        return this.especialidadMedico;
    }

}
