package com.jspl.lms.util;


import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;








public final class CommonUtils {
	private static final int ROUND_DECIMAL_PLACE = 2;
	static ResourceBundle bundle = ResourceBundle.getBundle("mail");
	 private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int RANDOM_STRING_LENGTH = 10;
		


	
	 
	
	
	
	public static String generateRandomString(){
        
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
     
    /**
     * This method generates random numbers
     * @return int
     */
    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    
    
	public static void sentMailForPassword(String username, String password) {
		try{
			
		
			
			
			String body="Dear Customer,<br><br> Below are the Credentials  <br>"
					+ " <br>userName:- "+username+"<br> Password:-"+password+"<br> <br>Please Visit the Website to get updates "
					+" <br><br><br>Regards,<br> Panther Admin<br><br><br><br>'This is electronically generated email,So don't revert back'";
			Properties props = new Properties();
			props.put("mail.smtp.host", bundle.getString("mail.smtp.host"));
	        props.put("mail.smtps.auth", bundle.getString("mail.smtp.auth"));
	        props.put("mail.smtp.starttls.enable", bundle.getString("mail.smtp.starttls.enable"));   
	        props.put("mail.smtp.port", bundle.getString("mail.smtp.port"));
	        props.put("mail.imap.port", bundle.getString("mail.imap.port"));
			Session session = Session.getDefaultInstance(props);

			 MimeMessage	message = new MimeMessage(session);
			 message.setSentDate(new Date());
			 if(username!=null ){
					message.setRecipients(Message.RecipientType.TO,username);
					}
			 message.setFrom(new InternetAddress("sales@jindalpanther.com"));
			 //message.setRecipients(Message.RecipientType.CC, "sitikantha.pattanaik@jspl.com");
			// message.setRecipients(Message.RecipientType.BCC, "mreetunjay.kumar@jindalsteel.com");
			 message.addHeader("JSPL", "Jindal ");
				message.setSubject("JSPL credentials");
				BodyPart messageBodyPart1 = new MimeBodyPart(); 
				messageBodyPart1.setContent(body, "text/html");
				Multipart multipart = new MimeMultipart("mixed"); 
				multipart.addBodyPart(messageBodyPart1);  
				
				
				//6) set the multiplart object to the message object  
				message.setContent(multipart);  

				//7) send message  
				Transport.send(message);  
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}


}
