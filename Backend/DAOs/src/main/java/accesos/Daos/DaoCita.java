package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Cita;
import entidades.Paciente;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DaoCita extends Dao<Cita> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoCita() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public List<Cita> getCitasPaciente(Paciente paciente) {
        try{
            TypedQuery<Cita> citas = this._em.createNamedQuery("GetCitasPaciente", Cita.class);
            citas.setParameter("paciente", paciente).getResultList();

            List<Cita> resultado = citas.getResultList();
            return resultado;
        }catch (Exception ex) {
            return null;
        }
    }

}
