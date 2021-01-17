package transfer;

public class DtoEstado extends DtoBase {

    //Atributos
    private String nombre;

    private String estatus;

    //Relaciones
    private DtoPais pais;

    //Constructor
    public DtoEstado() {
        super();
    }

    public DtoEstado(long id) throws Exception {
        super(id);
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DtoPais getPais() {
        return pais;
    }

    public void setPais(DtoPais pais) {
        this.pais = pais;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
