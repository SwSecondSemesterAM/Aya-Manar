package MyPackage;

import java.util.Map;

public class Admin {

	private Product p;
	private static String email;
	private static String password;
	private static int Id;
	private static int phoneNumber;
	private static String Address;
	private static String Name;
	
	public void addnewProduct(String c , String n , String pic , String d , String Is)
	{
	p = new Product();
	p.setCategory(c);
	p.setPicture(pic);
	p.setdescription(d);
	p.setIsrequiredspecialtreatment(false);
	
	}

	public static void set_email(String email2) {
		
		email = email2;
		
	}

	public static void set_id(Integer id) {

		Id = id;
	}

	public static void set_phone(Integer phone) {
		
		phoneNumber = phone;
	}

	public static void set_address(String address) {
		Address = address;

	}

	public static void set_name(String name) {
		
		Name = name;

	}

	public static void set_password(String password2) {

        password = password2;
		
	}

	public static String get_email() {
		
		return email;
	}

	public static String get_password() {

		return password;
	}
	
	
	


}
