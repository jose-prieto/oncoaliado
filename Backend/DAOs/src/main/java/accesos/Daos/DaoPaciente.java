package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoPaciente extends Dao<Paciente> {

    private final EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoPaciente() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public Paciente getPacienteCedula(String correo) {
        try {
            TypedQuery<Paciente> paciente = this._em.createNamedQuery("getPacienteCorreo", Paciente.class);
            return paciente.setParameter("correo", correo).getSingleResult();
        } catch(Exception e) {
            if(e.getMessage().equals("getSingleResult() did not retrieve any entities.")) {
                return null;
            } else{
                throw e;
            }
        } finally{
            this._em.clear();
        }
    }

}
