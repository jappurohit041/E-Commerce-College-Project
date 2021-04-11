package com.controller;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LuckyDrawEmailServlet")
public class LuckyDrawEmailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailID=request.getParameter("emailAddress");
		System.out.println(emailID+"mail id");
		mailMethod(emailID);
		request.setAttribute("msg", "Mail Sent Succesfully");
		request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
	}
	public static void mailMethod(String emailID) {
		final String username = "YOUR_EMAILID";
        final String password = "YOUR_EMAILPASSWORD";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        System.out.println("In mail Method");
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(emailID));
            message.setSubject("Discount From BigDeals.com");
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
          //  String htmlText = "<p>Respect Sir\\Madam<br>You have won special discount offer for our website. Please contact our admin to avail the discount.<br>Regards....<p><img src=\"cid:image\">";
            String htmlText = "<p>Respect Sir\\Madam<br>You have won special discount offer for our website. Please contact our admin to avail the discount.<br>Regards....<p>";
            
            messageBodyPart.setContent(htmlText, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
        //    DataSource fds = new FileDataSource("C:\\Users\\Jap Purohit\\Desktop\\Empty-Cart.jpg");

       //     messageBodyPart.setDataHandler(new DataHandler(fds));
         //   messageBodyPart.setHeader("Content-ID", "<image>");
            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}
}

