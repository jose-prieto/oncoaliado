package oncoaliado.Comandos.Ingresos;

import transfer.DtoLogin;

import javax.json.JsonObject;
import javax.ws.rs.core.Response;

public class PruebaCod {

    public static void main(String[] args) {
        //String passwordOriginal = "contraseña";
        //String passwordOriginal = "contraseña2";
        //String passwordOriginal = "contraseña3";
        String passwordOriginal = "prueba";

        Decodificación encoToFront = new Decodificación(passwordOriginal);
        Decodificación decoFromFront = new Decodificación(encoToFront.encodeFront());

        Decodificación encoToBack = new Decodificación(passwordOriginal);
        Decodificación decoToBack = new Decodificación(encoToBack.encodeBack());

        System.out.println("original: " + passwordOriginal);
        System.out.println("encriptado para front: " + encoToFront.encodeFront());
        System.out.println("traduccion: " + decoFromFront.decodeFront());
        System.out.println();
        System.out.println("original: " + passwordOriginal);
        System.out.println("encriptado para Back: " + encoToBack.encodeBack());
        System.out.println("Traduccion: " + decoToBack.decodeBack());

        //front encript
        //JhML9iRsUdRVx/q+DXpQOQ==
        //JhML9iRsUdQvoGMibm9JDA==
        //JhML9iRsUdQtVs/NzJcziw==
        //JhML9iRsUdSIfu+n5I28Xg==

        //back encript
        //bGwmWwPngpg0g9bUM+2ndQ==
        //bGwmWwPngpiI+yJLOcHVcA==
        //bGwmWwPngpio169hq0PlIA==
        //bGwmWwPngpi0MndkiYDRbA==

    }

}
