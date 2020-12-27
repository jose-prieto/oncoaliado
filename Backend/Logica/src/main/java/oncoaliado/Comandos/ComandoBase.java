package oncoaliado.Comandos;

import excepciones.Excepciones;

public abstract class ComandoBase<T> {

    public abstract void execute() throws Excepciones, Exception;

    public abstract T getResult() throws Excepciones;

}
