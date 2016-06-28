package com.centris.util;
//this is a file used to send mails
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;


public class SendMailWithAttachment {
	
//	String FILEPATH = "D:\\Ratna113.pdf";
//	String FROM_ADDRESS = "eattendencepro@gmail.com";
//	String SENDER_PASSWORD = "centris@123";
	String FROM_ADDRESS = "ranjith.sivan@spectrumconsultants.com";
	String SENDER_PASSWORD = "ranjith1234";
//	String FROM_ADDRESS = "ratnaraju.b@centrisinfotech.com";
//	String SENDER_PASSWORD = "R@tJ654#";
	
//	String 
	

	public void sendMail(String toAddress, String subject, String attachments[],String Bodymess)
	throws MessagingException, AddressException, Exception {

		String mailHost = JPropertyReader.getProperty("MAIL.SMTP.HOST");
		String mailPort = JPropertyReader.getProperty("MAIL.SMTP.PORT"); 
		String mailUser = JPropertyReader.getProperty("SENDER.MAIL.ID");
		String mailProtocal = JPropertyReader.getProperty("MAIL.TRANSPORT.PROTOCAL");
		String sendenName = JPropertyReader.getProperty("MAIL.SENDER.NAME"); 
		String startttlsEnable = JPropertyReader.getProperty("MAIL.SMTP.STARTTTLS.ENABLE");
		String mailPassword = JPropertyReader.getProperty("SENDER.MAIL.PASSWORD");
		String smtpAuth = JPropertyReader.getProperty("MAIL.SMTP.AUTH");
		FROM_ADDRESS = mailUser;
		SENDER_PASSWORD = mailPassword;
		
		System.out.println(" mailHost : "+mailHost);
		System.out.println(" mailPort : "+mailPort);
		System.out.println(" mailUser : "+mailUser);
		System.out.println(" mailProtocal : "+mailProtocal);
		System.out.println(" startttlsEnable : "+startttlsEnable);
		System.out.println(" mailPassword : "+mailPassword);
		System.out.println(" smtpAuth : "+smtpAuth);
		
		
		
//		ResourceBundle res = ResourceBundle.getBundle("com/centris/properties/BIO-TRACKER");
//		DriverName=res.getString("mySqlDriver");
//		protocal=res.getString("protocal");
//		ipaddress=res.getString("ipaddress");
//		String mailHost = res.getString("MAIL.SMTP.HOST");
//		String mailPort = res.getString("MAIL.SMTP.PORT"); 
//		String mailUser = res.getString("SENDER.MAIL.ID");
//		String mailProtocal = res.getString("MAIL.TRANSPORT.PROTOCAL");
//		
//		String startttlsEnable = res.getString("MAIL.SMTP.STARTTTLS.ENABLE");
//		String mailPassword = res.getString("SENDER.MAIL.PASSWORD");
//		String smtpAuth = res.getString("MAIL.SMTP.AUTH");
//		FROM_ADDRESS = mailUser;
//		SENDER_PASSWORD = mailPassword;
		
		
		
		System.out.println("Starting send mail ");
		try{        
        Properties props = System.getProperties();
//		props.put("mail.smtp.host","smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.user", FROM_ADDRESS);
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.auth", "true");
//        
//        
//      props.put("mail.transport.protocol", "smtp");
//		props.put("mail.smtp.host","mail.centrisinfotech.com");
//		props.put("mail.smtp.port", "25");
//		props.put("mail.smtp.user", FROM_ADDRESS);
//		props.put("mail.smtp.starttls.enable", "true");
//		props.setProperty("mail.smtp.ssl.trust", "smtpserver");
		
		
		   
        props.put("mail.transport.protocol",mailProtocal);
		props.put("mail.smtp.host",mailHost);
		props.put("mail.smtp.port",mailPort);
		props.put("mail.smtp.user", FROM_ADDRESS);
		props.put("mail.smtp.starttls.enable", startttlsEnable);
        props.put("mail.smtp.auth", smtpAuth);
		
//		String smtpSslTrust = res.getString("MAIL.SMTP.SSL.TRUST");
		String smtpSslTrust =  JPropertyReader.getProperty("MAIL.SMTP.SSL.TRUST");
		
		if(smtpSslTrust == null || smtpSslTrust.equalsIgnoreCase("")){
			
		}else{
			System.out.println(" smtpSslTrust : "+smtpSslTrust);
     		props.setProperty("mail.smtp.ssl.trust", smtpSslTrust);
     		
		}  
       
        
        
//      props.put("mail.transport.protocol", "smtp");
//      props.put("mail.smtp.host","smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.user", FROM_ADDRESS);
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.auth", "true");
//		props.setProperty("mail.smtp.ssl.trust", "smtpserver");
		

		
		Session mailSession = Session.getDefaultInstance(props, 
	    		  new javax.mail.Authenticator() {
	    		    protected PasswordAuthentication getPasswordAuthentication() {
	    		      return new PasswordAuthentication(FROM_ADDRESS,SENDER_PASSWORD );
	    		    }
	    		  }
	    	 );
		
		// SecurityManager security = System.getSecurityManager();

		Authenticator auth = new SMTPAuthenticator();

		// Get a mail session and authenticate user
		Session session = Session.getDefaultInstance(props, auth);

		// Define a new mail message
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendenName+"<"+FROM_ADDRESS+">"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
				toAddress));
		message.setSubject(subject);
		// Create a message part to represent the body text
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText(Bodymess);

		// use a MimeMultipart as we need to handle the file attachments
		Multipart multipart = new MimeMultipart();

		// add the message body to the mime message
		multipart.addBodyPart(messageBodyPart);

		// add any file attachments to the message
		addAtachments(attachments, multipart);

		System.out.println();
		// Put all message parts in the message
		message.setContent(multipart);

		// Send the message
		
		
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(mailHost, FROM_ADDRESS, SENDER_PASSWORD);
		
		transport.sendMessage(message, message.getAllRecipients());
		System.out.println("message sent");
		}catch (Exception e) {
			// TODO: handle exception
			Logger loggger = Logger.getLogger(SendMailWithAttachment.class);
			loggger.info("Exception in sendMail part ."+e);
			e.printStackTrace();
		}

	}
	
	

	// method to attach files to the body part
	protected void addAtachments(String[] attachments, Multipart multipart)
	throws MessagingException, AddressException {
		try{
			for (int i = 0; i <= attachments.length - 1; i++) {
		
			String filename = attachments[i];
			String Files = attachments[i].substring(attachments[i]
			                                                    .lastIndexOf("\\") + 1);

			MimeBodyPart attachmentBodyPart = new MimeBodyPart();

			// use a JAF FileDataSource as it does MIME type detection
			DataSource source = new FileDataSource(filename);
			attachmentBodyPart.setDataHandler(new DataHandler(source));

			// assume that the filename you want to send is the same as the
			// actual file name - could alter this to remove the file path
			attachmentBodyPart.setFileName(Files);

			// add the attachment
			multipart.addBodyPart(attachmentBodyPart);
		}
		}catch (Exception e) {
			// TODO: handle exception
			Logger loggger = Logger.getLogger(SendMailWithAttachment.class);
			loggger.info("Exception in addAtachments part ."+e);
		}
	}

	// mehtod to authenticate user
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(FROM_ADDRESS, SENDER_PASSWORD);
		}
	}
//************************************************************
	
	
	
	@SuppressWarnings("unchecked")
	public String sendReportToMail(EmailContent em) throws IOException {
		
//		String CSV_FILE = JPropertyReader.readProperty("ecardcsvfile");
//		CsvReader reader = new CsvReader(CSV_FILE);
//		reader.readHeaders(); 
//		File files = new File(ECARD_SLIPS_DIRECTORY); 
		
//		    em = new EmailContent();
		  
//		
		     String[] recipients = em.getMailids();
		     String subject = em.getSubject();
		     String message = em.getMessage();
		     String filePath = em.getFilepath();
		     
		     
				for (int i = 0; i < recipients.length; i++) { 
		
		
					try { 
						
						String[] fileNames = { filePath };
//						String to = email;
						System.out.println(recipients[i]);
						sendMail(recipients[i], subject, fileNames,message);
					     }

					catch (Exception e) {
						e.printStackTrace();
					} 
					
				}
			
		return "null";
	}	

	
	public static void main(String[] args) {
		
		try{
			
			EmailContent em = new EmailContent();
			String[] mails={"ratnaraju.b@centrisinfotech.com","ratnaraju.bonam@gmail.com","vijay.m@centrisinfotech.com"};
			em.setMailids(mails);
			em.setFilepath("C:\\Users\\mritunjay\\Downloads\\11-01-06-2014 - 30-06-2014 (1).pdf");
			em.setSubject(" Test Mail ");
			em.setMessage(" This is a Test mail sending through JAVA program ");
		 new SendMailWithAttachment().sendReportToMail(em);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}