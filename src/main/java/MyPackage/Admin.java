package MyPackage;

import java.util.Map;

public class Admin {

	private Product p;
	
	
	
	public void addnewProduct(String c , String n , String pic , String d , String Is)
	{
	p = new Product();
	p.setCategory(c);
	p.setname(n);
	p.setPicture(pic);
	p.setdescription(d);
	p.setIsrequiredspecialtreatment(false);
	
	}
	
	
	


}
