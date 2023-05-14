package MyPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
//record full information for the product (e.g. name, picture, description[dimension,
//material) , is required special treatment, etc..)
import java.util.logging.Logger;


public class Product {
	private static  LocalDate  Date;
	private static int number;
	private static int Rate;
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
	private static final String PRODUCT_FILENAME = "Products.txt";
	private static final String ERROR = "Error: ";
    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());





	
	
	
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

	

	
	public  static void create_Product(int nom , String CId  ,String dimention,String material ,  String Color , String category  , String PayType , int quantity ,String pic , double price , int rate )
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
		
		b = Test.checkPrice(price);
		if(b == false)
		{
			LOGGER.warning("wrong price");
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
		Product.setRate(0);

	}

	private static void setRate(int i) {


		Rate = i;
		
	}


	public static void AddProduct() {

		   try {
		        // Create the header line if the file is empty
		        File file = new File(PRODUCT_FILENAME);
		        boolean isEmpty = file.length() == 0;
		       
		        
		        // Append new records to the file
		        FileWriter writer = new FileWriter(PRODUCT_FILENAME, true);
		        if (Product.getCategory() != null && Product.getCID() != null && Product.getDimention() != null && Product.getMaterial() != null && Product.getColor() != null && Product.getPayment() != null && Product.getQuantity() != 0 && Product.getpicture() != null && Product.getStetus() != null && Product.getPrice() !=0) {
		            writer.write(Product.getNumber() + "\t" + Product.getCID() + "\t" + Product.getCategory() + "\t"+Product.getMaterial()+"\t" + Product.getColor() + "\t" + Product.getDimention() + "\t" + Product.getPayment() + "\t" + Product.getQuantity() + "\t" + Product.getpicture() + "\t" + Product.getStetus() + "\t" + Product.getIRS() + "\t" +Product.getPrice()+ "\t"+Product.getRate()+"\n");
		            writer.close();
		            LOGGER.log(java.util.logging.Level.INFO, "Your order now added, you can track your order and its status from your account.");
		        } else {
		            LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred: one or more required fields are missing.");
		        }
		    } catch (IOException e) {
		        LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred while writing to file.", e);
		    }
		
		
		
	}

	
	
	
	private static int getRate() {
		
		return Rate;
	}


	private static double getPrice() {
		return Price;
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
	        BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILENAME));
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

	
	
	public static void trackStatus(String customerId) {
	    boolean b = false;
	    Scanner s = new Scanner(System.in);
	    try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILENAME))) {
	        StringBuilder sb = new StringBuilder();
	        String header = reader.readLine(); // read and discard the header line
	        sb.append(header).append("\n");
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] data = line.split("\t"); // split the line into an array of values
	            if (data[1].equals(customerId)) { // check if the customer ID matches the desired ID
	                System.out.println("order with number " + data[0] + "  category " + data[2] + " Material " + data[3] + " Color " + data[4] + " dimention " + data[5] + " quantity " + data[7] + " picture " + data[8] + " is now in " + data[9] + " status" + "\n");
	                b = true;
	                if (data[9].equalsIgnoreCase("complete")) {
	                    System.out.println("How do you rate our cleaning?");
	                    System.out.println("1 , 2, ,3 ,4 or 5");
	                    int i = s.nextInt();
	                    data[12] = Integer.toString(i); // update the rating in the array
	                    String updatedLine = String.join("\t", data); // join the array values back into a tab-separated string
	                    sb.append(updatedLine).append("\n"); // append the updated line to the StringBuilder
	                }
	            } else {
	                sb.append(line).append("\n"); // append unchanged line to the StringBuilder
	            }
	        }
	        if (b == false) {
	            LOGGER.warning("You don't have any orders to track");
	        } else {
	            // Write the updated lines to the file
	            FileWriter writer = new FileWriter("Products.txt");
	            writer.write(sb.toString());
	            writer.close();
	            LOGGER.info("Ratings updated successfully.");
	        }
	    } catch (IOException e) {
	        LOGGER.log(java.util.logging.Level.SEVERE, "Error updating ratings: " + e.getMessage(), e);
	    }
	}

	
	
	  public static void deleteProduct(int idToDelete) {

		    try {
		        File inputFile = new File(PRODUCT_FILENAME);
		        final String PRODUCT_NUMBER_PREFIX = "product with number ";

		        File tempFile = new File("temp.txt");

		        // Create readers and writers for the input and output files
		        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		        // Read and skip the header line
		        String headerLine = reader.readLine();
		        String expectedHeader = "orderNum\tCusID\tcategory\tmaterial\tColor\tdimention\tpayType\tquantity\tpicture\tstatus\tIsReqy\tprice\trate";// modify this to match your actual header
		        
		        // Write the header line to the output file
		        writer.write(headerLine + System.lineSeparator());

		        // Read the remaining lines and write them to the output file
		        String line;
		        while ((line = reader.readLine()) != null) {
		        	String[] parts = line.split("\t");
		        	int id = Integer.parseInt(parts[0]);
		        	String status = parts[9];
		        	if (id == idToDelete && status.equals("waiting")) {
		        	    LOGGER.log(java.util.logging.Level.SEVERE, PRODUCT_NUMBER_PREFIX + idToDelete + " and status waiting deleted!");
		        	} else if (id != idToDelete) {
		        	    writer.write(line + System.lineSeparator());
		        	} else {
		        	    LOGGER.log(java.util.logging.Level.WARNING, PRODUCT_NUMBER_PREFIX + idToDelete + " cannot be deleted due to invalid status");
		        	}

		        }

		        // Close readers and writers
		        reader.close();
		        writer.close();

		        // Delete the input file and rename the temporary file to the input file name
		        if (!inputFile.delete()) {
		            LOGGER.log(java.util.logging.Level.WARNING, "Could not delete input file: " + inputFile.getName());
		            return;
		        }
		        if (!tempFile.renameTo(inputFile)) {
		            LOGGER.log(java.util.logging.Level.WARNING, "Could not rename temp file: " + tempFile.getName());
		        }

		    } catch (IOException e) {
		        LOGGER.log(java.util.logging.Level.SEVERE, ERROR + e.getMessage(), e);
		    }
		}
	
	
	
	
	  public static void updateProduct(int orderNumToUpdate, String CusID, String category,String material, String Color, String dimention, String payType, int quantity, String picture, String status, String IsReq , String Price , int rate) {

		    try {
		        File inputFile = new File(PRODUCT_FILENAME);
		        File tempFile = new File("temp.txt");

		        // Create readers and writers for the input and output files
		        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		        // Read and skip the header line
		        String headerLine = reader.readLine();
		        String expectedHeader = "orderNum\tCusID\tcategory\tmaterial\tColor\tdimention\tpayType\tquantity\tpicture\tstatus\tIsReq\tprice\trate";// modify this to match your actual header
		        
		        // Write the header line to the output file
		        writer.write(headerLine + System.lineSeparator());

		        // Read the remaining lines and write them to the output file
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] fields = line.split("\t");
		            int id = Integer.parseInt(fields[0]);
		            if (id != orderNumToUpdate) {
		                writer.write(line + System.lineSeparator());
		            } else {
		                // Write the updated line to the output file
		                String updatedLine = orderNumToUpdate + "\t" + CusID + "\t" + category + "\t" + material+"\t"+ Color + "\t" + dimention + "\t" + payType + "\t" + quantity + "\t" + picture + "\t" + status + "\t" + IsReq +"\t" + Price+"\t"+ rate;
		                writer.write(updatedLine + System.lineSeparator());
		                LOGGER.log(java.util.logging.Level.SEVERE, "product with number " + orderNumToUpdate + " updated!");
		            }
		        }

		        // Close readers and writers
		        reader.close();
		        writer.close();

		        // Delete the input file and rename the temporary file to the input file name
		        if (!inputFile.delete()) {
		            LOGGER.log(java.util.logging.Level.WARNING, "Could not delete input file: " + inputFile.getName());
		            return;
		        }
		        if (!tempFile.renameTo(inputFile)) {
		            LOGGER.log(java.util.logging.Level.WARNING, "Could not rename temp file: " + tempFile.getName());
		        }

		    } catch (IOException e) {
		        LOGGER.log(java.util.logging.Level.SEVERE, ERROR + e.getMessage(), e);
		    }
		}

	
	  public static String getRowByProductNumber(int productNumber) {
		    String row = null;
		    try {
		        File inputFile = new File(PRODUCT_FILENAME);
		        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

		        // Read and skip the header line
		        reader.readLine();

		        // Read the remaining lines and look for the matching product number
		        String line;
		        while ((line = reader.readLine()) != null) {
		            int id = Integer.parseInt(line.split("\t")[0]);
		            if (id == productNumber) {
		                row = line;
		                break;
		            }
		        }

		        // Close reader
		        reader.close();

		    } catch (IOException e) {
		        LOGGER.log(java.util.logging.Level.SEVERE, ERROR + e.getMessage(), e);
		    }

		    if (row == null) {
		        LOGGER.warning("No order found with number " + productNumber);
		        return null;
		        
		    }

		    return row;
		}


	
	  public static double calculatePrice(String category, double height, double width, boolean needsSpecialTreatment , int q) {
		    double basePrice = 0.0;
		    if (category.equalsIgnoreCase("carpet")) {
		        basePrice = 40.0;
		    } else if (category.equalsIgnoreCase("cover")) {
		        basePrice = 45.0;
		    } else {
		        // Invalid category
		        return -1.0;
		    }

		    double size = height * width;
		    double price = basePrice * size* q;
		    if (needsSpecialTreatment) {
		        price += 20.0;
		    }
		    return price;
		}

	
	  
	
	

}
