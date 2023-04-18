package MyPackage;

import java.util.ArrayList;
import java.util.Map;


public  class Customer {
	
	private int id;
	private static String name;
	private int phone;
	private String address;
	private double  payed_money;
	private static String password;
	private static boolean CustomerLogedIn = false;
	private boolean Is_request_the_service = false;
	private boolean customer_service_done = false;
	private String items;
	
	
	
	public Customer ()
	{
	
	}


	
	public Customer (String n , String ad , int id , int phone, double money , String password)
	{
		name =n;
		address = ad;
		this.id = id;
		this.phone = phone;
		payed_money = money;
		this.password = password;
		
		//customerList.add(n);//not sure
		
		
	}

	public void create_customer(String n , String ad , int id , int phone, double money)
	{
		name =n;
		address = ad;
		this.id = id;
		this.phone = phone;
		payed_money = money;
		this.password = password;
		
	}
	
	public void add_customer(String n)
	{
	//	customerList.add(n);
	}
	
	public void delete_customer(String n)
	{
		/*
	for(  String s : customerList  )
		{
			if(s.equalsIgnoreCase(n) )
			{
				customerList.remove(customerList .indexOf(n));
			}
		}
			
		*/
	}
	
	public void update_customer()
	{
		
	}
	
	
	public double  discount(double m) {
		
		
		System.out.println("You get a discount!");
		return 0.1*m;
		
	}

	public void set_id(int id) {
		
		this.id = id;
		
		
}
public static void setPassword(String pass) {
		password = pass;
		
	}
public void setAddress(String add) {
	this.address = add;
	
}
public void setPhone(int p) {
	
	this.phone = p;
}
public static void setName(String name2) {
	name =name2;
	
}
public void setPayedMoney(double d) {
	this.payed_money = d;
}

public double get_payedMoney()
{
	return payed_money;
	
}

public int Counter(int r)
{
	return r+1;
}

public static String get_name()
{
	return name;
	
}

public static String get_password( )
{
	return password;
	
}

public int get_id( )

{
	return id;
	
}

public static boolean getCustomerloged( )
{
	return CustomerLogedIn;
	
}


public boolean CustomerLogedIn() {
	
	return CustomerLogedIn;
 }



public static void setCustomerLogedIn( ) {

	CustomerLogedIn = true;
	
}



public void setCustomerLogedOut() {
	
	CustomerLogedIn = false;

	
}



public void set_request_the_service( ) {

	Is_request_the_service = true;
	
}



public void set_not_request_the_service() {
	
	Is_request_the_service = false;

	
}



public void set_customer_service_done( ) {

	customer_service_done = true;
	
}



public void set_customer_service_Notdone() {
	
	customer_service_done = false;

	
}

public void setitems(String items) {
	this.items =items;
	
}
public String get_items()
{
	return items;
	
}



}




