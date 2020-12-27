package oncoaliado.Comandos.Citas;

import accesos.DaoFactory;
import accesos.Daos.DaoCita;
import accesos.Daos.DaoMedico;
import entidades.Cita;
import entidades.Medico;
import excepciones.Excepciones;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

/**
 * @author José Prieto
 * @version 1.0
 */
public class ComandoGetAllCitasMedico extends ComandoBase {

    private List<Cita> citas;
    private long id;

    /**
     * Constructor de la clase.
     * @since 25/12/2020
     * @param id Objeto de tipo long con el id del médico (no del usuario).
     * @throws Excepciones "El id del médico debe ser mayor o igual a 0." en caso de que el id del médico no sea válido.
     */
    public ComandoGetAllCitasMedico(long id) throws Excepciones {
        try {
            if(id <= 0) {
                throw new Excepciones("El id del médico debe ser mayor o igual a 0.");
            }else {

                this.id = id;
            }
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método que busca al médico solicitado para luego buscar sus todas sus citas.
     * @since 25/12/2020
     * @see DaoMedico Objeto de acceso a datos usado.
     * @see Medico Entidad persistente usada guardar al médico buscado.
     * @throws Excepciones
     */
    @Override
    public void execute() throws Excepciones {
        try {
            DaoMedico daoMedico = DaoFactory.DaoMedicoInstancia();
            Medico medico = daoMedico.find(this.id, Medico.class);
            if (medico.getId() == 0) {
                throw new Excepciones("El id no coincide con ningún medico en la base de datos.");
            }else {
                DaoCita daoCita = DaoFactory.DaoCitaInstancia();
                this.citas = daoCita.getCitasMedico(medico);
            }
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

    /**
     * Método encargado de retornar las citas encontradas en caso de haber alguna.
     * @since 25/12/2020
     * @return Lista de objetos tipo Cita.
     * @see Cita Objeto persistente usado para retornar las citas encontradas.
     * @throws Excepciones
     */
    @Override
    public List<Cita> getResult() throws Excepciones{
        try {
            execute();
            return this.citas;
        }catch(Excepciones e) {
            throw e;
        }catch(Exception e) {
            throw e;
        }
    }

}
