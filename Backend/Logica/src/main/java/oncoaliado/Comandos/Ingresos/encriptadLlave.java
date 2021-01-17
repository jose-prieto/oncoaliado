package oncoaliado.Comandos.Ingresos;

public class encriptadLlave {
    public static void main(String[] args) {
        String password = "A12.34.56a";

        Decodificación deco = new Decodificación(password);
        Decodificación deco2 = new Decodificación(deco.encodeBack());
        Decodificación deco3 = new Decodificación(deco.encodeFront());
        String clave = deco.encodeBack();
        System.out.println(clave);
        System.out.println(deco3.decodeFront());
        System.out.println(deco2.decodeBack());
        System.out.println(deco3.encodeFront());
        //System.out.println(decoToBack.decodeBack());
    }

}
