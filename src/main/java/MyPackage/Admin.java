package MyPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
	private static final String FILENAME = "Products.txt";
	private static final String FILENAME2 = "Workers.txt";

	
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
		List<String[]> products = readDataFile(FILENAME);
		List<String[]> workers = readDataFile(FILENAME2);
		List<String[]> availableWorkers = getAvailableWorkers(workers);
		if (availableWorkers.size() == 0) {
		LOGGER.log(java.util.logging.Level.WARNING, "No available workers to assign orders.");
		return;
		}
		boolean orderAssigned = assignOrders(products, availableWorkers);
		if (!orderAssigned) {
		LOGGER.log(java.util.logging.Level.WARNING, "No orders available to assign to workers.");
		return;
		}
		writeDataFile("Products.txt", products);
		writeDataFile("Workers.txt", workers);
		} catch (IOException e) {
		LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred while");
		}
		}
		private static List<String[]> readDataFile(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String header = reader.readLine(); 
		List<String[]> data = new ArrayList<>();
		String line;
		while ((line = reader.readLine()) != null) {
		String[] rowData = line.split("\t");
		data.add(rowData);
		}
		reader.close();
		return data;
		}
		private static List<String[]> getAvailableWorkers(List<String[]> workers) {
		List<String[]> availableWorkers = new ArrayList<>();
		for (String[] workerData : workers) {
		if (workerData[5].equals("true")) {
		availableWorkers.add(workerData);
		}
		}
		return availableWorkers;
		}
		private static boolean assignOrders(List<String[]> products, List<String[]> availableWorkers) {
		for (String[] productData : products) {
		if (productData[9].equalsIgnoreCase("waiting")) {
		for (String[] workerData : availableWorkers) {
		if (workerData[5].equals("true")) {
		workerData[4] = productData[0];
		workerData[5] = "false";
		productData[9] = "in treatment";
		LOGGER.log(java.util.logging.Level.INFO, "Order " + productData[0] + " assigned to Worker " + workerData[1]);
		return true;
		}
		}
		}
		}
		return false;
		}
		private static void writeDataFile(String fileName, List<String[]> data) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		String header = String.join("\t", data.get(0));
		writer.write(header + "\n");
		for (int i = 1; i < data.size(); i++) {
		String row = String.join("\t", data.get(i));
		writer.write(row + "\n");
		}
		writer.close();
		}

	
	
	
	public static void generateReport() {
	    try {
	        // Read Products.txt

	        BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
	       // BufferedReader reader = new BufferedReader(new FileReader("Products.txt"));
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
	        reader = new BufferedReader(new FileReader(FILENAME2));
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