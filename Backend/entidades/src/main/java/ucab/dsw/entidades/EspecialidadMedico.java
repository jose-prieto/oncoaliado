package ucab.dsw.entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ESPECIALIDAD_MEDICO", schema = "ONCOALIADO")
public class EspecialidadMedico extends EntidadBase{

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    List<Cita> citas;

    @OneToMany(mappedBy = "medicoDiagnostico")
    List<Cita> citasDiagnostico;

    //Constructor

    public EspecialidadMedico() {
        super();
    }

    //Getters y Setters
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Cita> getCitasDiagnostico() {
        return citasDiagnostico;
    }

    public void setCitasDiagnostico(List<Cita> citasDiagnostico) {
        this.citasDiagnostico = citasDiagnostico;
    }
}
