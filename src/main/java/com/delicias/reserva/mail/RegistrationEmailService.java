package com.delicias.reserva.mail;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class RegistrationEmailService {

    public void sendRegistrationEmail(String email, String password) {

        String usuario = email;
        String contrasenia = password;

        // Recipient's email ID needs to be mentioned.
        String to = usuario;

        // Sender's email ID needs to be mentioned
        String from = "lavanderiautp2022iii@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lavanderiautp2022iii@gmail.com", "dhzzzgdhubnifqjk");
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Bienvenido a Delicias Gourmet!");

            // Now set the actual message
            message.setText(
                    "Bienvenid@ a Delicias Gourmet, desde este momento podrás acceder a tu cuenta.\n"
                            + "\n"
                            + "Recuerde que sus credenciales para el acceso son las siguientes:\n"
                            + "\n"
                            + "Usuario: "
                            + usuario
                            + "\n"
                            + "Clave: "
                            + contrasenia);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
