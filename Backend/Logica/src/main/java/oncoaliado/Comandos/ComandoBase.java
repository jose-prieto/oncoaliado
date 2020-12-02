package oncoaliado.Comandos;

public abstract class ComandoBase<T> {

    public abstract void execute();

    public abstract T getResult();

}
