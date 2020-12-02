package accesos;

public class DaoFactory {

    public static DaoEstado DaoEstadoInstance() {
        return new DaoEstado();
    }

    public static DaoEvento DaoEventoInstance() {
        return new DaoEvento();
    }

    public static DaoPais DaoPaisInstance() {
        return new DaoPais();
    }
}
