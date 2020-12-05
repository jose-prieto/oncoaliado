package oncoaliado.Comandos;

import excepciones.exceptions;

public abstract class ComandoBase<T> {

    public abstract void execute();

    public abstract T getResult() throws exceptions;

}
