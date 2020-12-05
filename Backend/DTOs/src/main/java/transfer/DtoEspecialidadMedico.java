package transfer;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

public class DtoEspecialidadMedico extends DtoBase {

    //Relaciones
    private DtoMedico medico;

    private DtoEspecialidad especialidad;

    private String estatus;

    //Constructor

    public DtoEspecialidadMedico() {
        super();
    }

    //Getters y Setters
    public DtoMedico getMedico() {
        return medico;
    }

    public void setMedico(DtoMedico medico) {
        this.medico = medico;
    }

    public DtoEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(DtoEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
