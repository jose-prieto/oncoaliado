package accesos.Daos;

import accesos.Dao;
import accesos.DaoFactory;
import accesos.DaoHandler;
import entidades.*;
import excepciones.Excepciones;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class DaoCita extends Dao<Cita> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoCita() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public List<Cita> getCitasMedico(Medico medico) {
        try{
            TypedQuery<Cita> citas = this._em.createNamedQuery("GetCitasMedico", Cita.class);
            return citas.setParameter("medico", medico).getResultList();
        }catch (Exception ex) {
            return null;
        }
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

    public List<Cita> getCitasPendientes() {
        try{
            TypedQuery<Cita> citas = this._em.createNamedQuery("GetCitasPendiente", Cita.class);
            citas.setParameter("estatus", "pendiente").setParameter("estatusFactura", "pagado").getResultList();

            List<Cita> resultado = citas.getResultList();
            return resultado;
        }catch (Exception ex) {
            return null;
        }
    }

    public List<Cita> getCitasInactivas(long id) throws Excepciones {
        try{
            if(id <= 0) {
                throw new Excepciones("El id del médico debe ser mayor o igual a 0.");
            }
            DaoEspecialidaMedico daoEspecialidadMedico = DaoFactory.DaoEspecialidaMedicoInstancia();
            TypedQuery<Cita> citas = this._em.createNamedQuery("GetCitasInactivas", Cita.class);
            citas.setParameter("estatus", "inactiva").setParameter("medicoEspecialidad", daoEspecialidadMedico.find(id, EspecialidadMedico.class)).getResultList();

            List<Cita> resultado = citas.getResultList();
            return resultado;
        }catch (Excepciones e) {
            return null;
        }
    }

    public BigDecimal getPrecio(long id) {
        try{
            DaoTipoCita daoTipoCita = DaoFactory.DaoTipoCitaInstancia();
            TypedQuery<BigDecimal> precio = this._em.createNamedQuery("getPrecio", BigDecimal.class);
            precio.setParameter("tipoCita", daoTipoCita.find(id, TipoCita.class)).getSingleResult();

            BigDecimal resultado = precio.getSingleResult();
            return resultado;
        }catch (Exception ex) {
            return null;
        }
    }

}
