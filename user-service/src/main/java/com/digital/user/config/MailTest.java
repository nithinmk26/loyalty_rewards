package com.digital.user.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.IOUtils;

public class MailTest {

	public static void main(String[] args) throws Exception {
		emailGenerator("nithinmk26@gmail.com", "Hello nithin");
		System.out.println("Mail Sent Successfully!!!!!!!!!!!!!!!!!");
	}

	public static void emailGenerator(String email, String message) throws MessagingException, Exception, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("komala.thagadaiah@gmail.com", "Bunny77!!");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		msg.setSubject("Your Account Creation  Status");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		StringWriter writer = new StringWriter();
		IOUtils.copy(new FileInputStream(new File("C:/poc_Loyalty/loyalty_rewards/user-service/src/main/resources/templates/mailTemplate.html")), writer);

		
		messageBodyPart.setContent(writer.toString(), "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		MimeBodyPart attachPart = new MimeBodyPart();
		msg.setContent(multipart);
		Transport.send(msg);
	}
}
