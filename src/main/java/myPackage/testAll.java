package myPackage;


import java.util.Scanner;
import java.util.logging.Logger;

public class testAll {


	private static String name;
	private static String phone;
	private static String address;
	private static String city;
	private static String email;
	private static String password;
	private static String id;
	static int press;
	private static int customerProductNumber ;
	private static String color;
	private static double height;
	private static double width;
	private static String dimention;
	private static String material;
	private static String payType;
	private static int q;
	private static String picture;
	private static String category;
	private static boolean rst;
	private static String adminName = "Ali";
	private static String adminPassword = "123";


    private static final String FILENAME = "Customers.txt";
    private static final Logger LOGGER = Logger.getLogger(testAll.class.getName());
    static final String YESORNO = "press 1 for yes , 2 for No";


	public static void main(String[] args) {
	    Scanner scanner3 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
	    Scanner scanner = new Scanner(System.in);
	    
	    
		System.out.println("Press 1 Admin form");
		System.out.println("Press 2 User form");

		press = scanner2.nextInt();

		if (press == 2)//User
		{
	    
		System.out.println("Welcome to our application!");
		System.out.println("Press 1 to sign Up");
		System.out.println("Press 2 to logIn");
		press = scanner2.nextInt();
		
		if(press == 1)
		{

	        signUp(scanner, scanner2, scanner3);
		 
		   
		}
		
		else if (press ==2 ) {
			
	        logIn(scanner, scanner2, scanner3);
			
		     
		}
		
	}
	
		else if (press == 1)
		{
			
			AdmiLogIn(scanner);
			
		}
		

		
	}
	


	private static void AdmiLogIn(Scanner scanner) {
		
		System.out.println("Enter UserName");
		String user = scanner.nextLine();

		System.out.println("Enter Password");
		String password = scanner.nextLine();

		if (isAdmin(user, password)) {
		    adminMenu(scanner);
		} else {
		    LOGGER.warning("Wrong User name or Password, try again...");
		}
		
	}



	private static void logIn(Scanner scanner, Scanner scanner2, Scanner scanner3) {
		
		
		
		 System.out.println("Enter Your email");
		    String user = scanner.nextLine();

		    System.out.println("Enter Password");
		    String password = scanner.nextLine();

		    boolean isValidCredentials = Customer.checkCustomerCredentials(FILENAME, user, password);

		    if (isValidCredentials) {
		        String name = Customer.findNameByEmail(user);
		        System.out.println("Welcome, " + name);

		        int press;

		        do {
		            System.out.println("Click 1 to order clean service");
		            System.out.println("Click 2 to track your orders");
		            System.out.println("Click 3 if you want to delete any order you have been ordered");
		            System.out.println("Click 4 if you want to update any order you have been ordered");
		            System.out.println("Press 0 to exit");

		            press = scanner2.nextInt();
		            scanner2.nextLine();

		            switch (press) {
		                case 1:
		                    orderCleanService(scanner, scanner2, scanner3 ,user);
		                    break;
		                case 2:
		                    trackOrders(scanner, user);
		                    break;
		                case 3:
		                    deleteOrder(scanner, scanner2, user);
		                    break;
		                case 4:
		                	updateOrder(scanner, scanner2, scanner3);
		                    break;
		                case 0:
		                    System.out.println("Goodbye!");
		                    return;
		                default:
		                    System.out.println("Invalid option. Please try again.");
		            }
		        } while (press != 0);
		    } else {
		        LOGGER.warning("Wrong username or password, try again!");
		    }
		
		
		
		
		
		
		
		
		
	}
	
	


	private static void deleteOrder(Scanner scanner, Scanner scanner2, String user) {


		   System.out.println("Which order do you want to delete? Enter the order number or choose an option:");
		    System.out.println("Press 1 to go to track");
		    System.out.println("Press 2 to enter order number");
		    System.out.println("Press 3 to return");

		    int press = scanner2.nextInt();
		    scanner2.nextLine();

		    if (press == 1) {
		        String id = Customer.findIdByEmail(user);
		        Product.trackStatus(id);
		    } else if (press == 2) {
		        System.out.println("Enter the order number you want to delete");
		        int number = scanner2.nextInt();
		        scanner2.nextLine();
		        Product.deleteProduct(number);
		    } else if (press == 3) {
		    	
					 return;
				 
		    }
		
		
	}



	private static void trackOrders(Scanner scanner, String user) {


		 String id = Customer.findIdByEmail(user);
		  Product.trackStatus(id);
		
		
	}



	private static void orderCleanService(Scanner scanner, Scanner scanner2, Scanner scanner3 , String User) {


		 System.out.println("What do you want to clean?");
		    System.out.println("Press 1 for carpet, 2 for cover");
		    int press = scanner2.nextInt();
		    scanner2.nextLine();

		    String category;
		    if (press == 1) {
		        category = "carpet";
		    } else {
		        category = "cover";
		    }

		    System.out.println("Material: ");
		    String material = scanner.nextLine();

		    System.out.println("Color: ");
		    String color = scanner.nextLine();

		    System.out.println("Height: ");
		    double height = scanner3.nextDouble();

		    System.out.println("Width: ");
		    double width = scanner3.nextDouble();

		    String dimension = height + "," + width;
		    
		    id = Customer.findIdByEmail(User);		    
			  
		     System.out.println("What method of payment will you be using?");
		     System.out.println("press 1 for Credit card");
		     System.out.println("press 2 for Cash");
		     press = scanner2.nextInt();
		     if (press == 1)
		     {
		    	 payType = "Credit Card";
		     }
		     else
		    	 payType = "Cash";
		     
		     System.out.println("Picture: ");
		     picture = scanner.nextLine();
		     System.out.println("Quantity: ");
		     q = scanner2.nextInt();
		     
		     customerProductNumber = Product.getLastOrderNumber();
		     customerProductNumber++; 
			

		 Product.create_Product(customerProductNumber, id,dimension ,material,  color, category, payType, q, picture ,  Product.calculatePrice(category, height, width, rst, q) , 0 );
		 System.out.println("Are you sure you want this order");
		 System.out.println("press 1 for Yes");
		 System.out.println("press 2 for No");

	     press = scanner2.nextInt();
	     if(press == 1)
	    	 Product.AddProduct();
	     else if (press == 2)
	    	 return;
		
		
	}



	private static void updateOrder(Scanner scanner,Scanner scanner2,Scanner scanner3) 
	
	{
		
		
		 System.out.println("What order number do you want to update?");
		    int orderNumber = scanner2.nextInt();
		    scanner2.nextLine();

		    String row = Product.getRowByProductNumber(orderNumber);
		    if (row == null) {
		        return;
		    }

		    String[] rowFile = row.split("\t");

		    updateField(scanner2, "category", rowFile[2], scanner);
		    updateField(scanner2, "material", rowFile[3], scanner);
		    updateField(scanner2, "color", rowFile[4], scanner);
		    updateField(scanner2, "dimension", rowFile[5], scanner3);
		    updateField(scanner2, "payment type", rowFile[6], scanner);
		    updateField(scanner2, "quantity", rowFile[7], scanner2);
		    updateField(scanner2, "picture", rowFile[8], scanner);

		    Product.updateProduct( customerProductNumber, rowFile[1], category, material, color, dimention, payType,q, picture, rowFile[9], rowFile[10], Double.toString(Product.calculatePrice(category, height, width, rst, q)), 0);
		
		
		
		
	}



	private static void updateField(Scanner scanner2, String fieldName, String defaultValue, Scanner scanner) {


		 System.out.println("Do you want to update " + fieldName + "?");
		    System.out.println(YESORNO);
		    int press = scanner2.nextInt();
		    if (press == 1) {
		        String updatedValue = null;
		        if (fieldName.equals("dimension")) {
		            System.out.println("Enter height");
		            double height = scanner.nextDouble();
		            System.out.println("Enter width");
		            double width = scanner.nextDouble();
		            updatedValue = height + "," + width;
		        } else {
		            System.out.println("Enter " + fieldName);
		            updatedValue = scanner.nextLine();
		        }
		        if (updatedValue != null && !updatedValue.isEmpty()) {
		            switch (fieldName) {
		                case "category":
		                    category = updatedValue;
		                    break;
		                case "material":
		                    material = updatedValue;
		                    if (material.equalsIgnoreCase("wool")) {
		                    	rst = true;
		                    }
		                    break;
		                case "color":
		                    color = updatedValue;
		                    break;
		                case "dimension":
		                    dimention = updatedValue;
		                    break;
		                case "payment type":
		                    payType = updatedValue;
		                    break;
		                case "quantity":
		                    q = Integer.parseInt(updatedValue);
		                    break;
		                case "picture":
		                    picture = updatedValue;
		                    break;
		            }
		        }
		    } else if (press == 2) {
		        switch (fieldName) {
		            case "category":
		                category = defaultValue;
		                break;
		            case "material":
		                material = defaultValue;
		                
		                break;
		            case "color":
		                color = defaultValue;
		                break;
		            case "dimension":
		                dimention = defaultValue;
		                break;
		            case "payment type":
		                payType = defaultValue;
		                break;
		            case "quantity":
		                q = Integer.parseInt(defaultValue);
		                break;
		            case "picture":
		                picture = defaultValue;
		                break;
		        }
		    }
		
	}



	private static void signUp(Scanner scanner, Scanner scanner2, Scanner scanner3) {

		    
		    System.out.println("Id: ");
		    id = scanner.nextLine();
		    System.out.println("name: ");

		    name = scanner.nextLine();
		    
		    System.out.println("Phone: ");
		    
		    phone = scanner.nextLine();

		    System.out.println("address: ");
		    
		    address = scanner.nextLine();
	        System.out.println("City: ");
		    
		    city = scanner.nextLine();
		    System.out.println("Email: ");
		    email = scanner.nextLine();
		    System.out.println("Password: ");
		    password = scanner.nextLine();
		    

		    System.out.println("Are you sure to submit?");
		    System.out.println("Press 1 for Yes");
		    System.out.println("Press 2 for No");
		     press = scanner2.nextInt();
		    
		    if (press == 1) {
		        Customer.createCustomer(id, name, phone, address, city, email, password, 0);
		        Customer.addCustomer(FILENAME);
		    } else {
		        return;
		    }
	}
		
	
	
	
	
	private static void adminMenu(Scanner scanner) {
	    System.out.println("Welcome to your page");
	    System.out.println("Press 1 to generate customized reports about business.");
	    System.out.println("Press 2 to Generate statistics");
	    System.out.println("Press 3 to Distribute the orders");
	    System.out.println("Press 4 to send invoice to customer when it's complete");

	    int press = scanner.nextInt();
	    scanner.nextLine(); // Consume newline character

	    switch (press) {
	        case 1:
	            Admin.generateReport();
	            break;
	        case 2:
	            Customer.getStatistics();
	            break;
	        case 3:
	            Admin.distributeOrdersToWorkers();
	            break;
	        case 4:
	            System.out.println("Customer email to send invoice: ");
	            String email = scanner.nextLine();
	            Customer.generateInvoice(email);
	            break;
	        default:
	            LOGGER.warning("Invalid input: " + press);
	            break;
	    }}
	
	private static boolean isAdmin(String username, String password) {
	    return username.equals(adminName) && password.equals(adminPassword);	
	}
	
	
	
	
	
	}

	

