package MyPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.swing.text.Document;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public  class Customer {
	
    private static final Logger LOGGER = Logger.getLogger(Customer.class.getName());
	private static final String FILENAME = "Customers.txt";
	private static final String PRODUCTS_FILENAME = "Products.txt";
	private static final String COMPLETE = "complete";
	
	private static String  id;
	private static  String name;
	private static  String phone;
	private static String address;
	private static String City;
	private static String email;
	private static double  payed_money;
	private static double  debts;
	private static String password;
	private static boolean CustomerLogedIn = false;
	private static boolean Is_request_the_service = false;
	private static int ferquently;
	private static ArrayList <Product> product = new ArrayList <Product>() ;
	private static boolean b;
	
	
	
	
	

	private Customer(String id2, String name2, String phone2, String address2, String city2, String email2,
			String password2) {

		id =id2;
		name = name2;
		phone = phone2;
		address = address2;
		City = city2;
		email = email2;
		password = password2;

		
		
	}



	public  static void create_customer(String ID , String n , String phone , String add , String city,String email , String Password , int freq)
	{
		b = Test.checkID(ID);
		if(b == false)
		{
			LOGGER.warning("ID is wrong!");
			return;
		}
		b = Test.checkName(n);
		if(b == false)
		{
			LOGGER.warning("Name is wrong!");
			return;
		}
		
		b = Test.checkPhone(phone);
		if(b == false)
		{
			LOGGER.warning("Phone is wrong!");
			return;
		}
		b = Test.checkAddress(add);
		if(b == false)
		{
			LOGGER.warning("Address is wrong!");
			return;
		}
		b = Test.checkEmail(email);
		if(b == false)
		{
			LOGGER.warning("Email is wrong!");
			return;
		}
		b = Test.checkPassword(Password);
		if(b == false)
		{
			LOGGER.warning("Password is wrong!");
			return;
		}
	
		
		
		Customer.setName(n);
		Customer.setPhone(phone);
		Customer.setAddress(add);
		Customer.set_email(email);
		Customer.setPassword(Password);
		Customer.setCity(city);
		Customer.set_id(ID);
		Customer.setfrequently(0);
		
		LOGGER.log(java.util.logging.Level.SEVERE,  "Welcome to our application, " + Customer.get_name() + "!");

	}
	
	private static void setfrequently(int i) {


		ferquently = i;
		
	}

	private static void setCity(String city) {


		City = city;
		
	}

	
	public static void deleteCustomer(String filename, int idToDelete) {

	    try {
	        File inputFile = new File(filename);
	        File tempFile = new File("temp.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String headerLine = reader.readLine();
	        String expectedHeader = "id\tName\tphone\tAddress\tCity\temail\tPassword\tfreq"; // modify this to match your actual header


	        writer.write(headerLine + System.lineSeparator());

	        String line;
	        while ((line = reader.readLine()) != null) {
	            int id = Integer.parseInt(line.split("\t")[0]);
	            if (id != idToDelete) {
	                writer.write(line + System.lineSeparator());
	            } else {
	                LOGGER.log(java.util.logging.Level.SEVERE, "Customer with id " + idToDelete + " deleted!");
	            }
	        }

	        reader.close();
	        writer.close();

	        if (!inputFile.delete()) {
	            LOGGER.log(java.util.logging.Level.WARNING, String.format("Could not delete input file: %s", inputFile.getName()));
	            return;
	        }
	        if (!tempFile.renameTo(inputFile)) {
	            LOGGER.log(java.util.logging.Level.WARNING, String.format("Could not rename temp file: %s", tempFile.getName()));	        }

	    } catch (IOException e) {
	        LOGGER.log(java.util.logging.Level.SEVERE, String.format("Error: %s", e.getMessage()), e);
	        }
	}

	
	

	public static void set_id(String iD2) {
		
		id = iD2;
		
		
}
public static void setPassword(String pass) {
		password = pass;
		
	}
public static void setAddress(String add) {
	address = add;
	
}
public static  void setPhone(String p) {
	
	phone = p;
}
public static void setName(String name2) {
	name =name2;
	
}
public static void setPayedMoney(double d) {
	payed_money = d;
}

public static  double get_payedMoney()
{
	return payed_money;
	
}

public static int Counter(int r)
{
	return r+1;
}

public static  String get_name()
{
	return name;
	
}

public static  String get_password( )
{
	return password;
	
}

public static String get_id( )

{
	return id;
	
}

public static  boolean getCustomerloged( )
{
	return CustomerLogedIn;
	
}


public static boolean CustomerLogedIn() {
	
	return CustomerLogedIn;
 }



public  static void setCustomerLogedIn( ) {

	CustomerLogedIn = true;
	
}



public static void setCustomerLogedOut() {
	
	CustomerLogedIn = false;

	
}



public static void set_request_the_service( ) {

	Is_request_the_service = true;
	
}



public static void set_not_request_the_service() {
	
	Is_request_the_service = false;

	
}



	


public static  void set_email(String email2) {
	
	email = email2;
	
}



public static  String get_email() {

	return email;
}



public static ArrayList<Product> getProduct() {

	return product;
}



public static String getAddetrss() {

	return address;
}



public static String getCity() {
	
 	return City;
}



public static int getFreq() {
	
	return ferquently;
}



public static double getDbts() {
	
	return debts;
}



public static void AddCustomer(String filename) {
    try {
        FileWriter writer = new FileWriter(filename, true);
        if(Customer.get_id() !=null && Customer.get_name() != null && Customer.getPhone() !=null && Customer.getAddetrss() !=null && Customer.getCity()!=null && Customer.get_email()!=null && Customer.get_password()!=null  );
        writer.write(Customer.get_id()+"\t"+Customer.get_name() +"\t"+Customer.getPhone()+"\t"+Customer.getAddetrss()+"\t" +Customer.getCity()+"\t" +Customer.get_email()+"\t" + Customer.get_password()+"\t"+Customer.getFreq()+"\n");
        writer.close();
    } catch (IOException e) {
    	
        LOGGER.log(java.util.logging.Level.SEVERE, "An error occurred while writing to file.", e);    }
}

static String getPhone() {

	return phone;
}



          	
public static void updateCustomer(String id, String name, String address, String city, String password, String email, String phone, int freq) {
	
	  try (RandomAccessFile raf = new RandomAccessFile(FILENAME, "rw")) {
	        String line;
	        long pos = 0;
	        boolean found = false;

           raf.readLine();
	       pos = raf.getFilePointer();

	        while ((line = raf.readLine()) != null) {
	            String[] parts = line.split("\t");
	            if (parts.length == 8 && parts[0].trim().equals(id)) { // trim the id value to remove any leading/trailing whitespace
	                found = true;
	                break;
	            }
	            pos = raf.getFilePointer();
	        }

	        if (found) {
	            // update the customer data
	            raf.seek(pos);
	            StringBuilder sb = new StringBuilder();
	            sb.append(id).append("\t").append(name).append("\t").append(phone).append("\t").append(address).append("\t").append(city).append("\t").append(email).append("\t").append(password).append("\t").append(freq).append("\n");

	            raf.writeBytes(sb.toString());
	            LOGGER.info(String.format("Customer with ID %s updated successfully.", id));
	        } else {
	        	LOGGER.warning(String.format("Customer with ID %s not found.", id));
	        }
	    } catch (IOException e) {
	    	LOGGER.log(java.util.logging.Level.WARNING, "Error updating customer: %s", e.getMessage());	    }

}


public static List<Customer> findByName(String fileName, String name) {
    List<Customer> matchingCustomers = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(fileName))) {
        
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        // Read customers
        while (scanner.hasNextLine()) {
            String[] fields = scanner.nextLine().split("\t");
            String customerName = fields[1];
            if (customerName.equalsIgnoreCase(name)) {
                Customer customer = new Customer(fields[0], customerName, fields[2], fields[3], fields[4], fields[5], fields[6]);
                matchingCustomers.add(customer);
		        LOGGER.info(customer.get_id());

            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    return matchingCustomers;
}
public static boolean checkCustomerCredentials(String filename, String email, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        boolean isFirstLine = true;
        while ((line = reader.readLine()) != null) {
            if (isFirstLine) { // skip the header line
                isFirstLine = false;
                continue;
            }
            String[] fields = line.split("\t");
            
            String customerEmail = fields[5].trim();
            String customerPassword = fields[6].trim();
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                return true;
            }
        }
    } catch (IOException e) {
    	LOGGER.warning(String.format("Error reading file %s: %s", filename, e.getMessage()));
    }
    return false;
}

public static String findNameByEmail(String email) {
    String fileName = FILENAME;
    String line = "";
    String name = "";
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        // Skip the header line
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\t");
            if (data.length ==8 && data[5].equals(email)) {
                name = data[1];
                break;
            }
        }
        reader.close();
    } catch (IOException e) {
    	LOGGER.warning(String.format("An error occurred: %s", e.getMessage()));
    }
    return name;
}



public static String findIdByEmail(String email) {
    String fileName = FILENAME;
    String line = "";
    String id = null; // Initialize the id variable to null
    try {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        // Skip the header line
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\t");
            if ( data[5].equals(email)) {
                id = data[0];
                break;
            }
        }
        reader.close();
    } catch (IOException e) {
    	LOGGER.warning(String.format("An error occurred: %s", e.getMessage()));
    }
    return id;
}

public static String getRowByCustomerEmail(String email) {
    String row = null;
    try {
        File inputFile = new File(FILENAME);
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String emailM = line.split("\t")[5];
            if (emailM.equals(email)) {
                row = line;
                break;
            }
        }

        // Close reader
        reader.close();

        if (row == null) {
        	LOGGER.warning(String.format("No order found with email %s", email));
            return null;
        }

    } catch (IOException e) {
        LOGGER.log(java.util.logging.Level.SEVERE, "Error: " + e.getMessage(), e);
    }

    return row;
}

public static void generateInvoice(String customerEmail) {
try {
LocalDate today = LocalDate.now();
String dateStr = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
String customerInformation = Customer.getRowByCustomerEmail(customerEmail);
if (customerInformation == null) {
return;
}
String[] customerTokens = customerInformation.split("\t");
File productFile = new File(PRODUCTS_FILENAME);
BufferedReader productReader = new BufferedReader(new FileReader(productFile));
List<String[]> products = new ArrayList<>();
String productLine;
while ((productLine = productReader.readLine()) != null) {
String[] productTokens = productLine.split("\t");
if (productTokens.length >= 10 && productTokens[9].equalsIgnoreCase(COMPLETE)
&& productTokens[1].equals(customerTokens[0])) {
products.add(productTokens);
}
}
productReader.close();
// Check if there are any products with state "complete"
if (products.isEmpty()) {
LOGGER.info(String.format("No products with state \"complete\" found for customer with email %s", customerEmail));
return;
}
// Add customer information
String fileName = String.format("Invoice_%s_%d.txt", customerEmail, new Date(0).getTime());
FileWriter fileWriter = new FileWriter(fileName);
fileWriter.write("Customer Information%n");
fileWriter.write(String.format("Customer Id: %s%n", customerTokens[0]));
fileWriter.write(String.format("Name: %s%n", customerTokens[1]));
fileWriter.write(String.format("Email: %s%n", customerTokens[5]));
fileWriter.write(String.format("Delivery Address: %s - %s%n", customerTokens[3], customerTokens[4]));
fileWriter.write(String.format("Delivery Date: %s%n%n", dateStr));
// Add items to be cleaned
fileWriter.write("Items to be Cleaned%n");
for (String[] productTokens : products) {
	fileWriter.write(String.format("- Order number: %s%n", productTokens[0]));
	fileWriter.write(String.format("- Category: %s%n", productTokens[2]));
	fileWriter.write(String.format("- Material: %s%n", productTokens[3]));
	fileWriter.write(String.format("- Color: %s%n", productTokens[4]));
	fileWriter.write(String.format("- Dimension: %s%n", productTokens[5]));
	fileWriter.write(String.format("- Quantity: %s%n", productTokens[7]));
	fileWriter.write(String.format("- Picture: %s%n", productTokens[8]));


if (Double.parseDouble(productTokens[7]) > 400.0 && Integer.parseInt(customerTokens[7]) > 10) {
double discount = 0.1 * Double.parseDouble(productTokens[7]);
double calc = Double.parseDouble(productTokens[7]) - discount;
productTokens[7] = Double.toString(calc);
fileWriter.write("You get 10% discount!%n");
}
fileWriter.write(String.format("- Price: %s%n%n", productTokens[11]));
}
fileWriter.close();
LOGGER.info("Invoice generated successfully.");
} catch (IOException e) {
	LOGGER.log(java.util.logging.Level.SEVERE, String.format("Error generating invoice: %s", e.getMessage()), e);
}
}

public static void getStatistics() {
    double totalDelivered = 0;
    double totalCash = 0;
    double totalPaid = 0;
    double totalDebts = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILENAME));
         PrintWriter writer = new PrintWriter(new FileWriter("statistics.txt"))) {

        String header = reader.readLine(); // read and discard the header line
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\t");

            if (data[9].equalsIgnoreCase(COMPLETE)) {
                double price = Double.parseDouble(data[11]);
                double quantity = Double.parseDouble(data[7]);
                totalDelivered += quantity;

                if (data[6].equalsIgnoreCase("Cash")) {
                    totalCash += price;
                } else if (data[6].equalsIgnoreCase("Credit card")) {
                    totalPaid += price;
                } else {
                    totalDebts += 0;
                }
            }
        }

        writer.printf("Total Delivered: %.2f%n", totalDelivered);
        writer.printf("Total Cash: %.2f%n", totalCash);
        writer.printf("Total Paid: %.2f%n", totalPaid);
        writer.printf("Total Debts: %.2f%n", totalDebts);

        LOGGER.info("This is your statistics");

    } catch (IOException e) {
        e.printStackTrace();
    }
}



}



        







