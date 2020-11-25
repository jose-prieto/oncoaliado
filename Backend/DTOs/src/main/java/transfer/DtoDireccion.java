package transfer;

public class DtoDireccion extends DtoBase{

    private String nombre;

    public DtoDireccion() {
    }

    public DtoDireccion(long id) throws Exception {
        super(id);
    }

    public DtoDireccion(long id, String nombre) throws Exception {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
