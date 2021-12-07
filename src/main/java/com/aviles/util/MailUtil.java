package com.aviles.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {

    public static void sendMessage(String from, String to, String subject, String body, boolean bodyIsHtml) throws MessagingException {

        //get a mail session with properties for gmail
        Properties props = new Properties();
        props.put("mail.transport.protocol","smtps");
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.port","465");
        props.put("mail.smtps.auth","true");
        props.put("mail.smtps.quitwait","false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        //create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if(bodyIsHtml){
            message.setContent(body, "text/html");
        }
        else {
            message.setText(body);
        }

        //create the addresses for the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        String email = "YOUR GMAIL USERNAME";
        String password = "YOUR GMAIL PASSWORD";

        //send the message
        Transport transport = session.getTransport();
        transport.connect(email, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
