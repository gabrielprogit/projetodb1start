package br.com.db1.model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.omg.CORBA.Environment;
public class JavaMailApp {
	static Session session; //declarar como um atributo de classe e static(global)
	public static void main(String[] args) {  
        Properties props = new Properties();  
        /** Parâmetros de conexão com servidor Hotmail */  
        props.put("mail.transport.protocol", "smtp");  
        props.put("mail.smtp.host", "smtp.live.com");  
        props.put("mail.smtp.socketFactory.port", "587");  
        props.put("mail.smtp.socketFactory.fallback", "false");  
        props.put("mail.smtp.starttls.enable", "true");  
        props.put("mail.smtp.auth", "true");  
        props.put("mail.smtp.port", "587");  
       session = Session.getDefaultInstance(props,  
                    new javax.mail.Authenticator() {  
                         protected PasswordAuthentication getPasswordAuthentication()   
                         {  
                               return new PasswordAuthentication("sysoutech@hotmail.com", "Senhafacil123");  
                         }  
                    });  
        /** Ativa Debug para sessão */  
        session.setDebug(true);  
        enviaHotmail(); //chama o método que é declarado como static nesse contexto
  }  
	public static void enviaHotmail() {
		try {  
            Message message = new MimeMessage(session);  
            message.setFrom(new InternetAddress("sysoutech@hotmail.com")); //Remetente  
            message.setRecipients(Message.RecipientType.TO,   
                              InternetAddress.parse("geovanebsu8@hotmail.com")); //Destinatário(s)  
            message.setSubject("Testando Protocolo de Email");//Assunto  
            message.setText("As mina pira no Tester" +
            		"\n Hahahaha");  
            /**Método para enviar a mensagem criada*/  
            Transport.send(message);
            System.out.println("Feito!!!");  
       } catch (MessagingException e) {  
            throw new RuntimeException(e);  
      }  
	}
}