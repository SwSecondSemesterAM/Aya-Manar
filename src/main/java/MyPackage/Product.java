package MyPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
//record full information for the product (e.g. name, picture, description[dimension,
//material) , is required special treatment, etc..)
import java.util.logging.Logger;


public class Product {
	private static  LocalDate  Date;
	private static int number;
	private static String CID;
	private static String Category;
	private static  String Picture;
	private static  String description;
	private static boolean Isrequiredspecialtreatment ;
	private static int quantity;
	private static double Price;
	private static String status;
	private static String management;
	private static  String color;
	private static String payementType;
	private static String size;
	private static boolean b;	
	private static String Dimensions;
	private static String Material;
	private static final String FILENAME = "Products.txt";
    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());





	
	
	public Product()
	{
		
		
	}
	
	public Product(int nom  , String Category , String Picture , String description , boolean ST , int quantity, String status , String color ,String size, String PT , LocalDate  Date )
	{
		this.Category = Category;
		this.Picture = Picture;
		this.description = description;
		this.number = nom;
		this.Isrequiredspecialtreatment = ST;
		this.quantity = quantity;
		//this.Price = price;
		this.status = status;
		this.color = color;
		this.payementType = PT;
		this.Date = Date;
		this.size = size;
		
	}
	
	
	
	public void create_product( String Category , String Picture , String description )
	{
		
		this.Category = Category;
		this.Picture = Picture;
		this.description = description;
		
	}
	
/*	public Product add_product(String n)
	{
		
		
	}*/
	
	public static void delete_product(String n)
	{
		
		
	}
	
	public static void setCategory(String Cat) {
		Category = Cat;
		
	}
	
	
	public static void setPicture (String pic) {
		Picture = pic;
		
	}
	public static void setdescription(String dis) {
		description = dis;
		
	}
	public static String getdescription() {

   return description;
		
	}
	public static void setIsrequiredspecialtreatment(boolean t) {
		
		Isrequiredspecialtreatment = t;
	}

	public static void setQuantity(int q) {

       quantity = q;
		
	}

	public static void setPrice(int price) {
		
		Price = price;
		
		
	}

	public  static String getCategory() {
		
		return Category;
	}

	public static String getSize() {

		return size;
		
	}

	public static int getQuantity() {

		return quantity;
	}

	public static int getNumber() {

		return number;
	}

	public static String getStetus() {

		return status;
	}

	

	
	public  static void create_Product(int nom , String CId  ,String dimention,String material ,  String Color , String category  , String PayType , int quantity ,String pic   )
	{
		
		
		b =   Test.checkColor(Color);

		if(b == false)
		{
			LOGGER.warning("Wrong Color");
			return;
		}
		b = Test.checkQuantity( quantity);
		if(b == false)
		{
			LOGGER.warning("Wrong quantity");
			return;
		}
		
		b = Test.isRequiredSpecialTreatment(category , material);
		if(b == false)
		{
			Product.setIsrequiredspecialtreatment(false);
		}
		else
			
			Product.setIsrequiredspecialtreatment(true);

		b = Test.checkPicture(pic);
		if(b == false)
		{
			LOGGER.warning("Wrong Picture");
			return;
		}
		b = Test.checkDimention(dimention);
		if(b == false)
		{
			LOGGER.warning("wrong dimention");
			return;
		}
		
		
		
		
		Product.setCategory(category);
		Product.setNumber(nom);
		Product.setCID(CId);
		Product.setDimention(dimention);
		Product.setMaterial(material);
		Product.setColor(Color);
		Product.setPayment(PayType);
		Product.setQuantity(quantity);
		Product.setPicture(pic);
		Product.setStatus("waiting");

		


	}

	public static void AddProduct() {

		   try {
		        // Create the header line if the file is empty
		        File file = new File(FILENAME);
		        boolean isEmpty = file.length() == 0;
		       
		        
		        // Append new records to the file
		        FileWriter writer = new FileWriter(FILENAME, true);
		        if (Product.getCategory() != null && Product.getCID() != null && Product.getDimention() != null && Product.getMaterial() != null && Product.getColor() != null && Product.getPayment() != null && Product.getQuantity() != 0 && Product.getpicture() != null && Product.getStetus() != null) {
		            writer.write(Product.getNumber() + "\t" + Product.getCID() + "\t" + Product.getCategory() + "\t" + Product.getColor() + "\t" + Product.getDimention() + "\t" + Product.getPayment() + "\t" + Product.getQuantity() + "\t" + Product.getpicture() + "\t" + Product.getStetus() + "\t" + Product.getIRS() + "\n");
		            writer.close();
		            LOGGER.log(java.util.logging.Level.INFO, "Your order now added, you can track your order and its status from your account.");
		        } else {
		            LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred: one or more required fields are missing.");
		        }
		    } catch (IOException e) {
		        LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred while writing to file.", e);
		    }
		
		
		
	}

	
	
	
	private static boolean getIRS() {
		
		return Isrequiredspecialtreatment;
	}

	private static Object getpicture() {
		
		
		return Picture;
	}

	private static Object getPayment() {


		return payementType;
	}

	private static Object getColor() {


		return color;
	}

	private static Object getMaterial() {


		return Material;
	}

	private static String getDimention() {


		return Dimensions;
	}

	private static String getCID() {


		return CID;
	}

	private static void setStatus(String string) {

		status = string;
		
	}

	private static void setPayment(String payType) {


		payementType = payType;
		
	}

	private static void setColor(String color2) {


		color = color2;
		
	}

	private static void setMaterial(String material2) {


		Material = material2;
		
	}

	private static void setDimention(String dimention) {


		Dimensions = dimention;
		
	}

	private static void setCID(String cId) {

		CID = cId;
		
	}

	private static void setNumber(int nom) {

		number = nom;
		
		
	}
	
	
	
	
	public static int getLastOrderNumber() {
	    int lastOrderNumber = 0;
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
	        String headerLine = reader.readLine(); // Skip the header line
	        String line;
	        while ((line = reader.readLine()) != null) {
	            // Split the line by tabs and extract the order number from the first field
	            String[] fields = line.split("\t");
	            int orderNumber = Integer.parseInt(fields[0]);
	            if (orderNumber > lastOrderNumber) {
	                lastOrderNumber = orderNumber;
	            }
	        }
	        reader.close();
	    } catch (IOException e) {
	        LOGGER.log(java.util.logging.Level.WARNING, "An error occurred while reading the products file.", e);
	    } catch (NumberFormatException e) {
	        LOGGER.log(java.util.logging.Level.WARNING, "An error occurred while parsing the order number.", e);
	    }
	    return lastOrderNumber;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
