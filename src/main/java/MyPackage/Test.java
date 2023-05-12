package MyPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.Socket;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Test {
	
	static boolean flag = false;

	
		
	

	public static boolean checkPhone(String Phone) {

		
		if(Phone.length() == 5)
		{
			
			char[] chars = Phone.toCharArray();
			for(char c : chars)
			{
				if(Character.isDigit(c)) 
				{
					flag = true;
				}
				else 
				{
					flag =false;
					break;
				}
				
			}
		}
		
		else flag = false;
		

		return flag;
	}

	public static boolean checkAddress(String address) {
		if(address.length() > 5)
			flag = true;
		else flag = false;

		return flag;
	}

	public static boolean checkEmail(String email) {
		if(email.length() > 10 )
		{
			if(email.contains("@gmail.com"))
			{
				flag = true;
			}
		}
		else
			flag  = false;


		return flag;
	}

	public static boolean checkID(String id) {
		if(id.length() == 3)
		{
			
			char[] chars = id.toCharArray();
			for(char c : chars)
			{
				if(Character.isDigit(c)) 
				{
					flag = true;
				}
				else 
				{
					flag =false;
					break;
				}
				
			}
		}
		else flag = false;
		
		return flag;
	}

	public static boolean checkPassword(String password) {
		if(password.length() < 30)
		{
			char[] chars = password.toCharArray();
			for(char c : chars)
			{
				if(Character.isDigit(c)) 
				{
					flag = true;
					break;
				}
				else
					flag = false;
				
			}
			
			for(char c : chars)
			{
				if(Character.isLowerCase(c)) 
				{
					flag = true;
					break;
				}
				else
					flag = false;
				
			}
			for(char c : chars)
			{
				if(Character.isUpperCase(c)) 
				{
					flag = true;
					break;
				}
				else
					flag = false;
				
			}
			
		}
		else flag = false;

		
		
		return flag;
	}

	public static boolean checkLog(String key, ArrayList<String> keyArray, int i) {

		
		
		if(keyArray.get(i).equals(key))
		{
			flag = true;
		
		}
		else flag = false;

		return flag;
	}

	public static int checkindex(String keyName, ArrayList<String> email) {

		int i = 0;
		for(String e : email)
		{
			if(e.equals(keyName))
			{
				i = email.indexOf(e);	
				return i;
			}
			
			
		}
		return -1;
	}

	
		
		
		
	

	
		
	

	public static boolean checkIsrequiredspecialtreatment(boolean Isrequiredspecialtreatment) {
		
		
		
		if(Isrequiredspecialtreatment == true)
		{	
			System.out.println("It's requiredspecialtreatment !");
			flag = false;
		
		}
		
		else 
		
		{
				flag = true;
		}
			
		
		return flag;
	}
	
	


	public static void sendEmail(String recipient, String subject, String body) throws MessagingException {
	   // SMTP server details
	   String host = "smtp.gmail.com";
	   String port = "465";
	   final String username = "cleaningserviceam2023@gmail.com";
	   final String password = "123123AyaManar";
	   
	   // Set email properties
	   Properties props = new Properties();
	   props.put("mail.smtp.host", host);
	   props.put("mail.smtp.port", port);
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.ssl.enable", "true");

	   // Create a session with SMTP authentication
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	         return new javax.mail.PasswordAuthentication(username, password);
	      }
	   });

	   
	   try {
           // Create a default MimeMessage object.
           MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
           message.setFrom(new InternetAddress(username));

           // Set To: header field of the header.
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

           // Set Subject: header field
           message.setSubject(subject);

           // Now set the actual message
           message.setText(body);

           System.out.println("sending...");
           // Send message
           Transport.send(message);
           System.out.println("Sent message successfully....");
       } catch (MessagingException mex) {
           mex.printStackTrace();
       }
	}

	public static boolean checkColor(String color) {
	    String[] validColors = {"red", "green", "blue", "yellow", "black", "white", "silver"};
	    for (String validColor : validColors) {
	    	
	        if (validColor.equalsIgnoreCase(color)) {
	            return true;
	        }
	    }
	    
	    return false;
	}

	public static boolean checkMaterial(String material , String category) {
		
		 String[] validCarpetMaterials = {"Wool", "Cotton", "Olefin", "Polyester", "Nylon", "Jute" , "Silk"};
		 String[] validCoverMaterials = {"Cotton", "Polyester", "Leather", "Velvet", "Linen", "Silk", "Acrylic"};
		 if(category.equalsIgnoreCase("carpet"))
			{
		    for (String validMaterial : validCarpetMaterials) {
		    	
		        if (validMaterial.equalsIgnoreCase(material)) {
		            return true;
		        }
		    }
		    
		   
		}
		 
		 else if(category.equalsIgnoreCase("cover")) 
		 {
			 for (String validMaterial : validCoverMaterials) {
			    	
			        if (validMaterial.equalsIgnoreCase(material)) {
			            return true;
			        }
			    }
			 
			 
		 }

		 return false;
}

	public static boolean checkQuantity(int quantity) {
		
		 if(quantity > 0 && quantity <= 100) {
			 
		        return true;
		        
		    } 
		 else 
			 
		 {
		        return false;
		 }

	}

	public static boolean isRequiredSpecialTreatment(String category, String material) {
	
		
		
	    if (category.equalsIgnoreCase("Carpet") || category.equalsIgnoreCase("Cover"))
	    {

	        if (material.equalsIgnoreCase("Silk") || material.equalsIgnoreCase("Wool")) {
	            return true;
	        }
	    }
	    return false;
		
		
	}

	public static boolean checkPicture(String pic) {

		    String extension = pic.substring(pic.lastIndexOf(".") + 1).toLowerCase();
		    if(!pic.isEmpty()) {
		    	
		    if(extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png") || extension.equals("gif") || extension.equals("bmp"))
		    return true;
		    

		}
	    	return false;

	}

	public static boolean checkDimention(String dimention) {

		
		String []s = dimention.split(",");
		
		if(Double.parseDouble(s[0]) > 0  &&  Double.parseDouble(s[1]) > 0  )
		{
			
			return true;
			
		}

		
		return false;
	}
	
	
		
	public static boolean checkName(String name) {
	    if (name == null || name.isEmpty()) {
	        return false;
	    }
	    for (char c : name.toCharArray()) {
	        if (!Character.isLetter(c) && c != ' ') {
	            return false;
	        }
	    }
	    return true;
	}

	public static boolean checkPrice(double price) {
	
		if(price > 20.0)
		{
			return true;
		}
			
		return false;
		
	}

	

	
	
	
	
	
	
	
}

	









