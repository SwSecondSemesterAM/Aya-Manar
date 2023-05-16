package myPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;


public class Product {
	private static int number;
	private static int rate;
	private static String cId;
	private static String category;
	private static  String picture;
	private static boolean isrequiredSpecialTreatment ;
	private static int quantity;
	private static double price;
	private static String status;
	private static  String color;
	private static String payementType;
	private static String dimensions;
	private static String material;
	private static final String PRODUCT_FILENAME = "Products.txt";
	private static final String ERROR = "Error: ";
    private static final Logger LOGGER = Logger.getLogger(Product.class.getName());





	
	
	
	public static void setCategory(String cat) {
		category = cat;
		
	}
	
	
	public static void setPicture (String pic) {
		picture = pic;
		
	}

	public static void setIsrequiredSpecialTreatment(boolean t) {
		
		isrequiredSpecialTreatment = t;
	}

	public static void setQuantity(int q) {

       quantity = q;
		
	}

	public static void setPrice(int price2) {
		
		price = price2;
		
		
	}

	public  static String getCategory() {
		
		return category;
	}



	public static int getQuantity() {

		return quantity;
	}

	public static int getNumber() {

		return number;
	}

	public static String getStatus() {

		return status;
	}

	

	
	public  static void create_Product(int nom , String cId  ,String dimention,String material ,  String color , String category  , String payType , int quantity ,String pic , double price , int rate )
	{
		if (!Test.checkColor(color)) {
		    LOGGER.warning("Wrong Color");
		    return;
		}

		if (!Test.checkQuantity(quantity)) {
		    LOGGER.warning("Wrong quantity");
		    return;
		}

		Product.setIsrequiredSpecialTreatment(Test.isRequiredSpecialTreatment(category, material));

		if (!Test.checkPicture(pic)) {
		    LOGGER.warning("Wrong Picture");
		    return;
		}

		if (!Test.checkDimension(dimention)) {
		    LOGGER.warning("Wrong dimension");
		    return;
		}

		if (!Test.checkPrice(price)) {
		    LOGGER.warning("Wrong price");
		    return;
		}

		Product.setCategory(category);
		Product.setNumber(nom);
		Product.setCid(cId);
		Product.setDimention(dimention);
		Product.setMaterial(material);
		Product.setColor(color);
		Product.setPayment(payType);
		Product.setQuantity(quantity);
		Product.setPicture(pic);
		Product.setStatus("waiting");
		Product.setRate(0);

	}

	private static void setRate(int i) {


		rate = i;
		
	}


	public static void AddProduct() {

		   try {
		        // Create the header line if the file is empty
		        File file = new File(PRODUCT_FILENAME);
		       
		        
		        // Append new records to the file
		        FileWriter writer = new FileWriter(PRODUCT_FILENAME, true);
		        if (Product.getCategory() != null && Product.getCID() != null && Product.getDimention() != null && Product.getMaterial() != null && Product.getColor() != null && Product.getPayment() != null && Product.getQuantity() != 0 && Product.getpicture() != null && Product.getStatus() != null && Product.getPrice() !=0) {
		            writer.write(Product.getNumber() + "\t" + Product.getCID() + "\t" + Product.getCategory() + "\t"+Product.getMaterial()+"\t" + Product.getColor() + "\t" + Product.getDimention() + "\t" + Product.getPayment() + "\t" + Product.getQuantity() + "\t" + Product.getpicture() + "\t" + Product.getStatus() + "\t" + Product.getIRS() + "\t" +Product.getPrice()+ "\t"+Product.getRate()+"\n");
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
		
		return rate;
	}


	private static double getPrice() {
		return price;
	}

	private static boolean getIRS() {
		
		return isrequiredSpecialTreatment;
	}

	private static Object getpicture() {
		
		
		return picture;
	}

	private static Object getPayment() {


		return payementType;
	}

	private static Object getColor() {


		return color;
	}

	private static Object getMaterial() {


		return material;
	}

	private static String getDimention() {


		return dimensions;
	}

	private static String getCID() {


		return cId;
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


		material = material2;
		
	}

	private static void setDimention(String dimention) {


		dimensions = dimention;
		
	}

	private static void setCid(String cId2) {

		cId = cId2;
		
	}

	private static void setNumber(int nom) {

		number = nom;
		
		
	}
	
	
	
	
	public static int getLastOrderNumber() {
	    int lastOrderNumber = 0;
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(PRODUCT_FILENAME));
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
	            FileWriter writer = new FileWriter(PRODUCT_FILENAME);
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
	
	
	
	
	  public static void updateProduct(int orderNumToUpdate, String cusId, String category,String material, String color, String dimention, String payType, int quantity, String picture, String status, String isReq , String price , int rate) {

		    try {
		        File inputFile = new File(PRODUCT_FILENAME);
		        File tempFile = new File("temp.txt");

		        // Create readers and writers for the input and output files
		        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		        // Read and skip the header line
		        String headerLine = reader.readLine();
		        
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
		                String updatedLine = orderNumToUpdate + "\t" + cusId + "\t" + category + "\t" + material+"\t"+ color + "\t" + dimention + "\t" + payType + "\t" + quantity + "\t" + picture + "\t" + status + "\t" + isReq +"\t" + price+"\t"+ rate;
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

		        reader.readLine();

		        String line;
		        while ((line = reader.readLine()) != null) {
		            int id = Integer.parseInt(line.split("\t")[0]);
		            if (id == productNumber) {
		                row = line;
		                break;
		            }
		        }

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
