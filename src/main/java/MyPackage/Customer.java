package MyPackage;

import java.util.ArrayList;


public class Customer {
	
	private int id;
	private String name;
	private int phone;
	private String address;
	private ArrayList<String> customerList= new ArrayList<String>();

	public void create_customer(String n , String ad , int id , int phone)
	{
		name =n;
		address = ad;
		this.id = id;
		this.phone = phone;
		customerList.add(n);//not sure
		
	}
	
	public void add_customer(String n)
	{
		customerList.add(n);
	}
	
	public void delete_customer(String n)
	{
		for(  String s : customerList  )
		{
			if(s.equalsIgnoreCase(n) )
			{
				customerList.remove(customerList .indexOf(n));
			}
		}
		
		
		
	}
	
	public void update_customer()
	{
		
	}
	
	public ArrayList<String> get_List()
	{
		return customerList;
	}

	public void discount() {
		
		System.out.println("You get a discount!");
		
	}
	
	
	
	

}




