package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoEspecialidaMedico;
import accesos.Daos.DaoPaciente;
import accesos.Daos.DaoTipoCita;
import entidades.*;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;
import transfer.DtoCita;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoUpdateCita extends ComandoBase {

    private Cita cita = FactoryEntidades.CitaInstancia();
    private DtoCita dtoCita;
    private DaoCita daoCita = DaoFactory.DaoCitaInstancia();

    /**
     * Constructor de la clase
     * @since 25/12/2020
     * @param dtoCita Objeto del tipo DtoCita
     * @see DtoCita Objeto usado para armar la entidad a actualizar;
     * @throws Excepciones
     */
    public ComandoUpdateCita(DtoCita dtoCita) throws Excepciones {
        try{
            if(dtoCita == null){
                throw new Excepciones("Objeto DtoCita recibido no debe ser null.");
            }else if(dtoCita.getId() <= 0) {
                throw new Excepciones("El id de la cita debe ser mayor o igual a 0.");
            }else if(dtoCita.getEstatus() == null) {
                throw new Excepciones("La cita debe tener un Status.");
            }else if(!dtoCita.getEstatus().equals("inactiva") && !dtoCita.getTipoCita().equals("pendiente") &&
                        !dtoCita.getTipoCita().equals("en proceso") && !dtoCita.getTipoCita().equals("lista")) {
                throw new Excepciones("Los tipo de cita válido son ");
            }else if(dtoCita.getFecha() == null) {
                throw new Excepciones("La cita debe tener una fecha asignada.");
            }else if(dtoCita.getMedico() == null) {
                throw new Excepciones("La cita debe tener algún médicoEspecialidad asignado.");
            }
            this.dtoCita = dtoCita;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de cargar los datos nuevos de la cita a actualizar
     * @see DaoEspecialidaMedico Data access object usado para buscar al objeto EspecialidadMedico en caso de existir.
     * @see EspecialidadMedico Entidad persistente usada para insertar el objeto del mismo tipo en la cita en cuestión.
     * @see DaoPaciente Data access object encargado de buscar a un paciente registrado en la base de datos.
     * @see Paciente Entidad persistente donde se almacena al paciente encontrado para luego asignarlo a la cita.
     * @see DaoTipoCita Data access object encargado de buscar a un TipoPaciente registrado en la base de datos.
     * @see TipoCita Entidad persistente donde se guardan los datos del TipoCita encontrados para luego asignarlo a la cita.
     * @throws Excepciones En caso de una búsqueda mal que retorne null.
     */
    @Override
    public void execute() throws Excepciones {
        try{
            this.cita = this.daoCita.find(dtoCita.getId(), Cita.class);

            if(this.cita == null) {
                throw new Excepciones("La cita especificada no existe en la base de datos.");
            }

            this.cita.setEstatus(this.dtoCita.getEstatus());
            this.cita.setFecha(this.dtoCita.getFecha());
            this.cita.setDescripcion(this.dtoCita.getDescripcion());

            DaoEspecialidaMedico daoMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
            if(this.dtoCita.getMedico() != null) {
                EspecialidadMedico especialidadMedico = daoMedico.find(this.dtoCita.getMedico().getId(), EspecialidadMedico.class);
                if(especialidadMedico == null) {
                    throw new Excepciones("La especialidad medico especificada no existe en la base de datos.");
                }
                this.cita.setMedico(especialidadMedico);
            }

            if(this.dtoCita.getMedicoDiagnostico() != null) {
                EspecialidadMedico especialidadMedicoDiagnostico = daoMedico.find(this.dtoCita.getMedico().getId(), EspecialidadMedico.class);
                if(especialidadMedicoDiagnostico == null) {
                    throw new Excepciones("La especialidad medico diagnostico especificada no existe en la base de datos.");
                }
                this.cita.setMedicoDiagnostico(especialidadMedicoDiagnostico);
            }

            DaoPaciente daoPaciente = DaoFactory.DaoPacienteInstancia();
            if(this.dtoCita.getPaciente() != null) {
                Paciente paciente = daoPaciente.find(this.dtoCita.getPaciente().getId(), Paciente.class);
                if (paciente == null) {
                    throw new Excepciones("el paciente especificado no se encuentra registrado en la base de datos.");
                }
                this.cita.setPaciente(paciente);
            }

            DaoTipoCita daoTipoCita = DaoFactory.DaoTipoCitaInstancia();
            if(this.dtoCita.getTipoCita() != null) {
                TipoCita tipoCita = daoTipoCita.find(dtoCita.getTipoCita().getId(), TipoCita.class);
                if(tipoCita == null) {
                    throw new Excepciones("El TipoCita Especificado no existe en la base de datos.");
                }
                this.cita.setTipoCita(tipoCita);
            }

            this.cita = daoCita.update(this.cita);

        } catch(Excepciones e) {
            throw e;
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de retornar la cita recién actualizada.
     * @return Objeto de tipo Cita
     * @see Cita
     * @throws Excepciones
     */
    @Override
    public Cita getResult() throws Excepciones {
        try {
            execute();
            return this.cita;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
