package oncoaliado.Comandos.Correos;

import transfer.DtoCorreo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ComandoCorreo {

    private DtoCorreo correo;
    private final String correoOnco = "oncoaliadoprueba@gmail.com";

    public ComandoCorreo(DtoCorreo dtoCorreo) {
        this.correo = dtoCorreo;
    }

    public Message enviarCorreo(Session session, Properties props, String correo) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(props.getProperty("from")));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
            message.setSubject(this.correo.getAsunto());
            message.setText("Nombre: " + this.correo.getNombre() + "\n\n" + this.correo.getContenido());
            return message;
        } catch(Exception ex) {
            return null;
        }

    }

    public void execute() throws MessagingException {
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("from", this.correoOnco);
        props.put("username", this.correoOnco);
        props.put("password", "Onco24%%");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
            }
        });

        Transport.send(enviarCorreo(session, props, this.correo.getCorreo()));
        Transport.send(enviarCorreo(session, props, this.correoOnco));
    }

}
