package MyPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Admin {

	private Product p;
	private static String email;
	private static String password;
	private static int Id;
	private static int phoneNumber;
	private static String Address;
	private static String Name;
    private static final Logger LOGGER = Logger.getLogger(Admin.class.getName());

	
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
	
	public static void distributeOrdersToWorkers() {
	    try {
	        // read products file
	        BufferedReader productReader = new BufferedReader(new FileReader("Products.txt"));
	        String productHeader = productReader.readLine(); // read and discard the header line

	        List<String[]> products = new ArrayList<>();
	        String productLine;
	        while ((productLine = productReader.readLine()) != null) {
	            String[] productData = productLine.split("\t");
	            products.add(productData);
	        }
	        productReader.close();

	        // read workers file
	        BufferedReader workerReader = new BufferedReader(new FileReader("Workers.txt"));
	        String workerHeader = workerReader.readLine(); // read and discard the header line

	        List<String[]> workers = new ArrayList<>();
	        String workerLine;
	        while ((workerLine = workerReader.readLine()) != null) {
	            String[] workerData = workerLine.split("\t");
	            workers.add(workerData);
	        }
	        workerReader.close();

	        // create a list of available workers
	        List<String[]> availableWorkers = new ArrayList<>();
	        for (String[] workerData : workers) {
	            if (workerData[5].equals("true")) {
	                availableWorkers.add(workerData);
	            }
	        }

	        if (availableWorkers.size() == 0) {
	            LOGGER.log(java.util.logging.Level.WARNING, "No available workers to assign orders.");
	            return;
	        }

	        // assign orders to available workers
	        boolean orderAssigned = false;
	        for (String[] productData : products) {
	            if (productData[9].equalsIgnoreCase("waiting")) {
	                for (String[] workerData : availableWorkers) {
	                    if (workerData[5].equals("true")) {
	                        // assign the order to the worker
	                        workerData[4] = productData[0];
	                        workerData[5] = "false";

	                        // update the product status to "in treatment"
	                        productData[9] = "in treatment";

	                        LOGGER.log(java.util.logging.Level.INFO, "Order " + productData[0] + " assigned to Worker " + workerData[1]);
	                        orderAssigned = true;
	                        break;
	                    }
	                }
	            }
	            if (orderAssigned) {
	                break;
	            }
	        }

	        if (!orderAssigned) {
	            LOGGER.log(java.util.logging.Level.WARNING, "No orders available to assign to workers.");
	            return;
	        }

	        // write the updated products data to file
	        BufferedWriter productWriter = new BufferedWriter(new FileWriter("Products.txt"));
	        productWriter.write(productHeader + "\n");
	        for (String[] productData : products) {
	            String productLineStr = String.join("\t", productData);
	            productWriter.write(productLineStr + "\n");
	        }
	        productWriter.close();

	        // write the updated workers data to file
	        BufferedWriter workerWriter = new BufferedWriter(new FileWriter("Workers.txt"));
	        workerWriter.write(workerHeader + "\n");
	        for (String[] workerData : workers) {
	            String workerLineStr = String.join("\t", workerData);
	            workerWriter.write(workerLineStr + "\n");
	        }
	        workerWriter.close();

	    } catch (IOException e) {
	        LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred while");

	    }
	}
	
	
	
	public static void generateReport() {
	    try {
	        // Read Products.txt
	        BufferedReader reader = new BufferedReader(new FileReader("Products.txt"));
	        String header = reader.readLine(); // read and discard the header line

	        // Print column headers for the relevant columns
	        String productHeaders = String.format("%-10s%-15s%-15s%-10s\n", "Order No.", "Customer ID", "Category", "Rating");

	        FileWriter writer = new FileWriter("Report.txt");
	        writer.write(productHeaders);

	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] data = line.split("\t");

	            // Check if the rating is greater than 0 and write the relevant columns to the report file
	            if (Double.parseDouble(data[12]) > 0) {
	                String reportLine = String.format("%-10s%-15s%-15s%-10s\n", data[0], data[1], data[2], data[12]);
	                writer.write(reportLine);
	            }
	        }
	        reader.close();
	        
	        // Read Workers.txt
	        reader = new BufferedReader(new FileReader("Workers.txt"));
	        header = reader.readLine(); // read and discard the header line
	        
	        // Print column headers for worker info
	        String workerHeaders = String.format("ID\tName\tPhone\tEmail\tOrdersNom\tavailable\n");
	        writer.write("\n" + workerHeaders);

	        while ((line = reader.readLine()) != null) {
	            String workerLine = line + "\n";
	            writer.write(workerLine);
	        }
	        reader.close();
	        
	        writer.close();
	        LOGGER.info("Report generated successfully!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}