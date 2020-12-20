package transfer;

import java.util.GregorianCalendar;

public class DtoGenerarCitas {

    //Atributos
    private GregorianCalendar fecha;
    private int duracion;
    private int cantCitas;

    //Constructores
    public DtoGenerarCitas() {

    }

    //Getters y Setters
    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCantCitas() {
        return cantCitas;
    }

    public void setCantCitas(int cantCitas) {
        this.cantCitas = cantCitas;
    }
}
