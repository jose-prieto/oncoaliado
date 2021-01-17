package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.EspecialidadMedico;
import entidades.Medico;
import excepciones.Excepciones;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoEspecialidaMedico extends Dao<EspecialidadMedico> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEspecialidaMedico() {
        super( _handler );
        this._em = _handler.getSession();
    }

    public EspecialidadMedico getEspecialidadMedicoCorreo(String correo) {
        try {
            TypedQuery<EspecialidadMedico> especialidadMedico = this._em.createNamedQuery("getEspcialidadMedicoCorreo", EspecialidadMedico.class);
            return especialidadMedico.setParameter("correo", correo).getSingleResult();
        }catch(Exception e) {
            if(e.getMessage().equals("getSingleResult() did not retrieve any entities.")) {
                return null;
            } else{
                throw e;
            }
        }finally {
            this._em.clear();
        }
    }

}
