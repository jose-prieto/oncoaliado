package oncoaliado.Comandos.Ingresos;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class Decodificación {

    private final String keyFront = "5K9dy%;2@!85Df";
    private final String keyBack = "6ki5d%2e";
    private String password;

    public Decodificación(String password) {
        this.password = password;
    }

    public String encodeFront() {
        try {
            /*MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llave = md5.digest(this.keyFront.getBytes(StandardCharsets.UTF_8));
            byte[] bytesKey = Arrays.copyOf(llave, 24);
            SecretKey key = new SecretKeySpec(bytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);*/

            byte[] textoPlano = password.getBytes(StandardCharsets.UTF_8);
            //byte[] buffer = cifrado.doFinal(textoPlano);
            byte[] base64Bytes = Base64.encodeBase64(textoPlano);

            return new String(base64Bytes);
        }catch(Exception ex) {
            return ex.getMessage();
        }
    }

    public String decodeFront() {
        try {
            /*MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] password = Base64.decodeBase64(this.password.getBytes(StandardCharsets.UTF_8));
            byte[] digestOfPassword = md5.digest(this.keyFront.getBytes(StandardCharsets.UTF_8));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword,24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);*/

            //byte[] textoPlano = decipher.doFinal(password);
            byte[] textoPlano = Base64.decodeBase64(this.password);
            return new String(textoPlano, "UTF-8");
        }catch(Exception ex) {
            return ex.getMessage();
        }
    }

    public String encodeBack() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llave = md5.digest(this.keyBack.getBytes(StandardCharsets.UTF_8));
            byte[] bytesKey = Arrays.copyOf(llave, 24);
            SecretKey key = new SecretKeySpec(bytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);

            byte[] textoPlano = password.getBytes(StandardCharsets.UTF_8);
            byte[] buffer = cifrado.doFinal(textoPlano);
            byte[] base64Bytes = Base64.encodeBase64(buffer);

            return new String(base64Bytes);
        }catch(Exception ex) {
            return ex.getMessage();
        }
    }

    public String decodeBack() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] password = Base64.decodeBase64(this.password.getBytes(StandardCharsets.UTF_8));
            byte[] digestOfPassword = md5.digest(this.keyBack.getBytes(StandardCharsets.UTF_8));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword,24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] textoPlano = decipher.doFinal(password);
            return new String(textoPlano, "UTF-8");
        }catch(Exception ex) {
            return ex.getMessage();
        }
    }
}
