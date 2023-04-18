package MyPackage;

import java.util.ArrayList;
//record full information for the product (e.g. name, picture, description[dimension,
//material) , is required special treatment, etc..)

public class Product {
	
	
	private String Category;
	private String name;
	private String Picture;
	private String description;
	private boolean Isrequiredspecialtreatment = false;
	public Product()
	{
		
		
	}
	
	public Product(String name , String Category , String Picture , String description )
	{
		this.name = name;
		this.Category = Category;
		this.Picture = Picture;
		this.description = description;
		
	}
	
	
	
	public void create_product(String name , String Category , String Picture , String description )
	{
		this.name = name;
		this.Category = Category;
		this.Picture = Picture;
		this.description = description;
		
	}
	
/*	public Product add_product(String n)
	{
		
		
	}*/
	
	public void delete_product(String n)
	{
		
		
	}

	public void checkout() {
		
		System.out.println("your order is complete!");
	}



	public void checkout2() {

		System.out.println("your order have not complete yet!");
		
	}
	
	
	
	public void setCategory(String Cat) {
		this.Category = Cat;
		
	}
	public void setname(String n) {
		this.name = n;
		
	}
	
	public void setPicture (String pic) {
		this.Picture = pic;
		
	}
	public void setdescription(String dis) {
		this.description = dis;
		
	}
	public String getdescription() {

   return description;
		
	}
	public void setIsrequiredspecialtreatment(boolean t) {
		
		this.Isrequiredspecialtreatment = t;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
