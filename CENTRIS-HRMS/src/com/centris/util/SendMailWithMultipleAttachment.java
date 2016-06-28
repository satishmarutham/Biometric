package com.centris.util;
//this is a file used to send mails
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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


public class SendMailWithMultipleAttachment {

	String FROM_ADDRESS = "ranjith.sivan@spectrumconsultants.com";
	String SENDER_PASSWORD = "ranjith1234";

	
	

	public synchronized String sendMail(String toAddress,InternetAddress[] ccList, String subject, List<String> attachments,String Bodymess)
	throws MessagingException, AddressException, Exception {
		
		String mailStatus=null;

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
		

		
		
		System.out.println("Starting send mail ");
		try{        
        Properties props = System.getProperties();

        props.put("mail.transport.protocol",mailProtocal);
		props.put("mail.smtp.host",mailHost);
		props.put("mail.smtp.port",mailPort);
		props.put("mail.smtp.user", FROM_ADDRESS);
		props.put("mail.smtp.starttls.enable", startttlsEnable);
        props.put("mail.smtp.auth", smtpAuth);
		

		String smtpSslTrust =  JPropertyReader.getProperty("MAIL.SMTP.SSL.TRUST");
		
		if(smtpSslTrust == null || smtpSslTrust.equalsIgnoreCase("")){
			
		}else{
			System.out.println(" smtpSslTrust : "+smtpSslTrust);
     		props.setProperty("mail.smtp.ssl.trust", smtpSslTrust);
     		
		}  
       

		
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
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
		message.setRecipients(Message.RecipientType.CC, ccList);
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
		mailStatus="true";
		}catch (Exception e) {
			// TODO: handle exception
			mailStatus="false";
			Logger loggger = Logger.getLogger(SendMailWithMultipleAttachment.class);
			loggger.info("Exception in sendMail part ."+e);
			e.printStackTrace();
		}
		
		return mailStatus;

	}
	
	

	// method to attach files to the body part
	protected void addAtachments(List<String> attachments, Multipart multipart)
	throws MessagingException, AddressException {
		try{
			for (int i = 0; i <= attachments.size() - 1; i++) {
		
			String filename = attachments.get(i);
			String Files = attachments.get(i).substring(attachments.get(i).lastIndexOf("/") + 1);

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
			Logger loggger = Logger.getLogger(SendMailWithMultipleAttachment.class);
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
	public synchronized String sendReportToMail(EmailContent em) throws IOException {
		
		String mailStatus=null;
	try{
		     String[] recipients = em.getMailids();
		     String subject = em.getSubject();
		     String message = em.getMessage();
		    List<String> fileNames = em.getAttachmultpleFiles();
		     String ccString="";
		     for (int i = 1; i < recipients.length; i++) {
		    	 if(recipients[i]!=null && !"".equals(recipients[i]) && !"null".equalsIgnoreCase(recipients[i]))
		    		 ccString=ccString+","+recipients[i];
		     }
		     if(!ccString.equals("")){
		    	 ccString=ccString.substring(1);
		     }
		     InternetAddress[] ccList = InternetAddress.parse(ccString);
		     mailStatus=sendMail(recipients[0],ccList, subject, fileNames,message);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return mailStatus;
	}	

	
	
	
	
	
	public synchronized String sendMailAllowances(String toAddress,InternetAddress[] ccList, String subject, List<String> attachments,String Bodymess)
			throws MessagingException, AddressException, Exception {
				
				String mailStatus=null;

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
				

				
				
				System.out.println("Starting send mail ");
				try{        
		        Properties props = System.getProperties();

		        props.put("mail.transport.protocol",mailProtocal);
				props.put("mail.smtp.host",mailHost);
				props.put("mail.smtp.port",mailPort);
				props.put("mail.smtp.user", FROM_ADDRESS);
				props.put("mail.smtp.starttls.enable", startttlsEnable);
		        props.put("mail.smtp.auth", smtpAuth);
				

				String smtpSslTrust =  JPropertyReader.getProperty("MAIL.SMTP.SSL.TRUST");
				
				if(smtpSslTrust == null || smtpSslTrust.equalsIgnoreCase("")){
					
				}else{
					System.out.println(" smtpSslTrust : "+smtpSslTrust);
		     		props.setProperty("mail.smtp.ssl.trust", smtpSslTrust);
		     		
				}  
		       

				
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
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
				message.setRecipients(Message.RecipientType.CC, ccList);
				message.setSubject(subject);
				// Create a message part to represent the body text
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(Bodymess);

				 message.setContent(Bodymess,"text/html");
				// Send the message
				
				
				Transport transport = mailSession.getTransport("smtp");
				transport.connect(mailHost, FROM_ADDRESS, SENDER_PASSWORD);
				
				transport.sendMessage(message, message.getAllRecipients());
				System.out.println("message sent");
				mailStatus="true";
				}catch (Exception e) {
					// TODO: handle exception
					mailStatus="false";
					Logger loggger = Logger.getLogger(SendMailWithMultipleAttachment.class);
					loggger.info("Exception in sendMail part ."+e);
					e.printStackTrace();
				}
				
				return mailStatus;

			}
			
			public synchronized String sendReportToMailAllowances(EmailContent em) throws IOException {
				
				String mailStatus=null;
			try{
				     String[] recipients = em.getMailids();
				     String subject = em.getSubject();
				     String message = em.getMessage();
				 
				    List<String> fileNames = em.getAttachmultpleFiles();
				     String ccString="";
				     for (int i = 1; i < recipients.length; i++) {
				    	 if(recipients[i]!=null && !"".equals(recipients[i]) && !"null".equalsIgnoreCase(recipients[i]))
				    		 ccString=ccString+","+recipients[i];
				     }
				     if(!ccString.equals("")){
				    	 ccString=ccString.substring(1);
				     }
				     InternetAddress[] ccList = InternetAddress.parse(ccString);
				     mailStatus=sendMailAllowances(recipients[0],ccList, subject, fileNames,message);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				return mailStatus;
			}
	public static void main(String[] args) {
		
		try{
			
			EmailContent em = new EmailContent();
			String[] mails={"satishmarutham@gmail.com","mritunjayku1@gmail.com"};
			em.setMailids(mails);
			List<String> filesPathList=new ArrayList<String>();
			filesPathList.add("C://Users//mritunjay//Downloads//IncorrectPunchRport-01-10-2014-30-10-2014(1).pdf");
			em.setAttachmultpleFiles(filesPathList);
			em.setSubject(" Test Mail ");
			em.setMessage(" This is a Test mail sending through JAVA program ");
		 new SendMailWithMultipleAttachment().sendReportToMail(em);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}