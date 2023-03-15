package MyPackage;

import java.util.ArrayList;

public class Product {
	
	
	private String Category;
	private String name;
	private String Picture;
	private String description;
	
	public  Product(String name , String Category , String Picture , String description )
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
	
	public void add_product(String n)
	{
		//customerList.add(n);
	}
	
	public void delete_product(String n)
	{
		
		
	}

	public void checkout() {
		
		System.out.println("your order is complete!");
	}



	public void checkout2() {

		System.out.println("your order have not complete yet!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
