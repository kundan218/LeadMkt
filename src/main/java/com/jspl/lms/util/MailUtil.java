package com.jspl.lms.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.stereotype.Component;

/**
 * The Class MailUtil is used to send mail in Common NFA portal. This is a
 * utility class having several features like sending mail with CC , BCC or
 * Attachments which can one, More , or Nothing.Use this class if you have to
 * send the mail in Common NFA
 * 
 * @version 1.0
 * @author mreetunjay
 * @since 16-04-2015
 */
@Component
public class MailUtil {
	
	/** The bundle here must be static because it has been used in static context. */
	static ResourceBundle bundle = ResourceBundle.getBundle("mail");
	
	/**
	 * Send mail for nfa.
	 *
	 * @param fromUser the from user
	 * @param toUser the to user
	 * @param ccUser the cc user
	 * @param bccUser the bcc user
	 * @param subject the subject
	 * @param body the body
	 * @param multipleFilePathList the multiple file path list
	 * @return true, if successful
	 */
	public static boolean sendMail(String fromUser ,List<String> toUser, List<String> ccUser, List<String> bccUser, String subject, String body, List<String> multipleFilePathList){
		
		boolean flag=false; 
		
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", bundle.getString("mail.smtp.host"));
	        props.put("mail.smtps.auth", bundle.getString("mail.smtp.auth"));
	        props.put("mail.smtp.starttls.enable", bundle.getString("mail.smtp.starttls.enable"));   
	        props.put("mail.smtp.port", bundle.getString("mail.smtp.port"));
	        props.put("mail.imap.port", bundle.getString("mail.imap.port"));
			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session); 
			if(fromUser!=null){
			message.setFrom(new InternetAddress(fromUser));  
			}
			
			//set the date and time
			message.setSentDate(new Date());
			
			if(toUser!=null && toUser.size()>0){
			message.setRecipients(Message.RecipientType.TO, calculateToCcAndBcc(toUser));
			}
			
			if(ccUser!=null && ccUser.size()>0){
				message.setRecipients(Message.RecipientType.CC, calculateToCcAndBcc(ccUser));
			}
			
			if(bccUser!=null && bccUser.size()>0){
				message.setRecipients(Message.RecipientType.BCC, calculateToCcAndBcc(bccUser));
			}

			message.addHeader("JSPL", "DMS");
			message.setSubject(subject);

			//3) create MimeBodyPart object and set your message text     
			BodyPart messageBodyPart1 = new MimeBodyPart(); 
			messageBodyPart1.setContent(body, "text/html");
			Multipart multipart = new MimeMultipart("mixed"); 
			multipart.addBodyPart(messageBodyPart1);  
			
			/*if(bos != null){
				// Now use your ByteArrayDataSource as
	               DataSource fds = new ByteArrayDataSource(bos.toByteArray(), "application/pdf");
	               
	               MimeBodyPart mbp2 = new MimeBodyPart();
	               mbp2.setDataHandler(new DataHandler(fds));   
	               mbp2.setFileName("requisition.pdf");
	               multipart.addBodyPart(mbp2); 
			}*/
			
			//Add single or multiple attachments
			/*if(multipleFilePathList!=null && multipleFilePathList.size()>0){
			multipart=addAttachmentsAndAddBodyPart(multipleFilePathList, multipart);
			}*/

			//6) set the multiplart object to the message object  
			message.setContent(multipart);  

			//7) send message  
			Transport.send(message);  
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	
	/**
	 * Calculate to cc and bcc.
	 *
	 * @param userList the user list
	 * @return the internet address[]
	 */
	public static InternetAddress[] calculateToCcAndBcc(List<String> userList){
		InternetAddress[] internetAddress =new InternetAddress[userList.size()];
		for (int i = 0; i < userList.size(); i++) {
			try {
				internetAddress[i] = new InternetAddress(userList.get(i));
			} catch (AddressException e) {
				e.printStackTrace();
			}   
		}  
		return internetAddress;
	}
	
	
	
	/**
	 * Adds the attachments and add body part.
	 *
	 * @param multipleFilePathList the multiple file path list
	 * @param multipart the multipart
	 * @return the multipart
	 */
	public static Multipart addAttachmentsAndAddBodyPart(List<String> multipleFilePathList, Multipart multipart){
		for (String str : multipleFilePathList) {
		    MimeBodyPart messageBodyPart = new MimeBodyPart();
		    DataSource source = new FileDataSource(str);
		    try {
		    	messageBodyPart.setDataHandler(new DataHandler(source));
			    messageBodyPart.setFileName(source.getName());
				multipart.addBodyPart(messageBodyPart);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		return multipart;
	}
	
	
	
	
	/**
	 * Gets the mime message for gmail.
	 *
	 * @return the mime message for gmail
	 */
	public MimeMessage getMimeMessage(){
		MimeMessage message = null;
		try {
			  Properties properties = new Properties();
              String path=this.getClass().getClassLoader().getResource("mail.properties").getPath();
              InputStream input = null;
              input = new FileInputStream(path);
              properties.load(input);
			 Session session = Session.getDefaultInstance(properties);
			message = new MimeMessage(session);
		} catch (Exception e) {

		}
		return message;
	}


	public  void sendWishingMail(String fromUser, String emailId, String subject, String body) {
		// TODO Auto-generated method stub

		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", bundle.getString("mail.smtp.host"));
	        props.put("mail.smtps.auth", bundle.getString("mail.smtp.auth"));
	        props.put("mail.smtp.starttls.enable", bundle.getString("mail.smtp.starttls.enable"));   
	        props.put("mail.smtp.port", bundle.getString("mail.smtp.port"));
	        props.put("mail.imap.port", bundle.getString("mail.imap.port"));
			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session); 
			if(fromUser!=null){
			message.setFrom(new InternetAddress(fromUser));  
			}
			
			//set the date and time
			message.setSentDate(new Date());
			
			if(emailId!=null ){
			message.setRecipients(Message.RecipientType.TO, emailId);
			}
			
			
			message.addHeader("JSPL", "DMS");
			message.setSubject(subject);

			//3) create MimeBodyPart object and set your message text     
			BodyPart messageBodyPart1 = new MimeBodyPart(); 
			messageBodyPart1.setContent(body, "text/html");
			Multipart multipart = new MimeMultipart("mixed"); 
			multipart.addBodyPart(messageBodyPart1);  
			
			if(subject != null && subject.contains("Birthday")){
				System.out.println("Birthday");
		        MimeBodyPart iconBirthday = new MimeBodyPart();
	            DataSource iconbirthdaySource = new FileDataSource(
	                    new File(this.getClass().getClassLoader().getResource("BirthdayGreeting.jpg").getPath()));
	            iconBirthday.setDataHandler(new DataHandler(iconbirthdaySource));
	            iconBirthday.setDisposition(Part.INLINE);
	            iconBirthday.setContentID("<bicon>");
	            iconBirthday.addHeader("Content-Type", "image/jpeg");
	            multipart.addBodyPart(iconBirthday);
	        }
			
			if(subject != null && subject.contains("Anniversary")){
				System.out.println("Anniversary");
	            MimeBodyPart iconAnniversary = new MimeBodyPart();
	            DataSource iconAnniversarySource = new FileDataSource(
	                    new File(this.getClass().getClassLoader().getResource("AnniversaryGreeting.jpg").getPath()));
	            iconAnniversary.setDataHandler(new DataHandler(iconAnniversarySource));
	            iconAnniversary.setDisposition(Part.INLINE);
	            iconAnniversary.setContentID("<aicon>");
	            iconAnniversary.addHeader("Content-Type", "image/jpeg");
	            multipart.addBodyPart(iconAnniversary);
	        }
			
			if(subject != null && subject.contains("Shop")){
				System.out.println("Shop Opening");
	            MimeBodyPart iconAnniversary = new MimeBodyPart();
	            DataSource iconAnniversarySource = new FileDataSource(
	                    new File(this.getClass().getClassLoader().getResource("DealerAnniversaryGreeting.jpg").getPath()));
	            iconAnniversary.setDataHandler(new DataHandler(iconAnniversarySource));
	            iconAnniversary.setDisposition(Part.INLINE);
	            iconAnniversary.setContentID("<aicon>");
	            iconAnniversary.addHeader("Content-Type", "image/jpeg");
	            multipart.addBodyPart(iconAnniversary);
	        }
			//Add single or multiple attachments
		

			//6) set the multiplart object to the message object  
			message.setContent(multipart);  

			//7) send message  
			Transport.send(message);  
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	

}
