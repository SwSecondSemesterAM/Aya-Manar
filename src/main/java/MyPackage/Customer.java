package MyPackage;

import java.util.ArrayList;
import java.util.Map;


public class Customer {
	
	private int id;
	private String name;
	private int phone;
	private String address;
	private double  payed_money;
	private String password;
	private boolean CustomerLogedIn = false;
	
	
	
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
/*		for(  String s : customerList  )
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
public void setPassword(String pass) {
		this.password = pass;
		
	}
public void setAddress(String add) {
	this.address = add;
	
}
public void setPhone(int p) {
	
	this.phone = p;
}
public void setName(String name) {
	this.name =name;
	
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

public String get_name()
{
	return name;
	
}

public String get_password( )
{
	return password;
	
}

public boolean getCustomerloged( )
{
	return CustomerLogedIn;
	
}


public boolean CustomerLogedIn() {
	
	return CustomerLogedIn;
 }



public void setCustomerLogedIn( ) {

	CustomerLogedIn = true;
	
}



public void setCustomerLogedOut() {
	
	CustomerLogedIn = false;

	
}



}




