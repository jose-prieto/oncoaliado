package oncoaliado.Comandos.Medicos;

import accesos.DaoFactory;
import accesos.Daos.DaoEspecialidaMedico;
import entidades.EspecialidadMedico;
import oncoaliado.Comandos.ComandoBase;

import java.util.List;

public class ComandoGetAllMedicos extends ComandoBase {

    private List<EspecialidadMedico> medicos;

    public void QuitarContrasena() {
        for (EspecialidadMedico obj: this.medicos) {
            obj.getMedico().getUsuario().setContrasena(null);
            obj.getMedico().getUsuario().setCorreo(null);
        }
    }

    @Override
    public void execute() {
        DaoEspecialidaMedico dao = DaoFactory.DaoEspecialidaMedicoInstancia();
        this.medicos = dao.findAll(EspecialidadMedico.class);
        QuitarContrasena();
    }

    @Override
    public List<EspecialidadMedico> getResult() {
        return this.medicos;
    }

}
