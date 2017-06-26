package model;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import object.Pedido;


public class SendMail {

    public static void enviar(Pedido p) {

        final String username = " @gmail.com";
        final String password = " ";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(" @gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(" @gmail.com"));
            message.setSubject("Novo Pedido!");
            message.setText("Segue abaixo o novo pedido!"
                + "\n\n"+p.toString());

            Transport.send(message);

            System.out.println("Enviado!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
