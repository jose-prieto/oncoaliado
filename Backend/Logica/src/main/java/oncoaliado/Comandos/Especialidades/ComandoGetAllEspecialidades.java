package oncoaliado.Comandos.Especialidades;

import accesos.DaoFactory;
import accesos.Daos.DaoEspecialidad;
import entidades.Especialidad;
import excepciones.exceptions;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetAllEspecialidades extends ComandoBase {

    private List<Especialidad> especialidades = null;

    @Override
    public void execute() {
        try {
            DaoEspecialidad daoEspecialidad = DaoFactory.DaoEspecialidadInstancia();
            this.especialidades = daoEspecialidad.findAll(Especialidad.class);
        }catch(Exception e) {
            throw e;
        }
    }

    @Override
    public List<Especialidad> getResult() {
        try {
            return this.especialidades;
        }catch(Exception e) {
            throw e;
        }
    }

}
