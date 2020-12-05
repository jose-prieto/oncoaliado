package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.EspecialidadMedico;

import javax.persistence.EntityManager;

public class DaoEspecialidaMedico extends Dao<EspecialidadMedico> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoEspecialidaMedico() {
        super( _handler );
    }

}
