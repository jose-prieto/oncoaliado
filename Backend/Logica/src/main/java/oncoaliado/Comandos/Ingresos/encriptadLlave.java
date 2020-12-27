package oncoaliado.Comandos.Ingresos;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

public class encriptadLlave {
    public static void main(String[] args) {
        String password = "prueba";

        Decodificación deco = new Decodificación(password);
        Decodificación deco2 = new Decodificación(deco.encodeFront());
        String clave = deco.encodeFront();
        System.out.println(clave);
        System.out.println(deco2.decodeFront());
        System.out.println(deco.encodeBack());
        //System.out.println(decoToBack.decodeBack());
    }

}
