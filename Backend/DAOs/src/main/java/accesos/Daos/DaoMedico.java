package accesos.Daos;

import accesos.Dao;
import accesos.DaoHandler;
import entidades.Medico;
import entidades.Paciente;
import excepciones.Excepciones;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class DaoMedico extends Dao<Medico> {

    private EntityManager _em;
    static DaoHandler _handler = new DaoHandler();

    public DaoMedico() {
        super( _handler );
    }

}
