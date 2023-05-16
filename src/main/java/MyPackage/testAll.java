package MyPackage;


import java.util.Scanner;
import java.util.logging.Logger;

public class testAll {


	private static String Name , phone , address , city , email , password ;
	private static String id;
	static int press;
	private static boolean flag;
	private static int CustomerProductnom ;
	private static String color;
	private static double height;
	private static double width;
	private static String dimention;
	private static String material;
	private static String payType;
	private static int Q;
	private static String picture;
	private static String category;
	private static boolean RST;
	private static int number;
	private static String AdminName = "Ali";
	private static String AdminPass = "123";


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

	        String User = scanner.nextLine();
	        
	     System.out.println("Enter Password");
	     
	     String Password = scanner.nextLine();
	     
	  flag = Customer.checkCustomerCredentials(FILENAME, User, Password);
	  
	  System.out.println("Are you sure to submit?");
	    System.out.println("Press 1 for Yes");
		System.out.println("Press 2 for No");
		press = scanner2.nextInt();
	     if(press == 1)
	     {
	
	     if(flag)
	     {
	    	 Name = Customer.findNameByEmail(User);
			 System.out.println("Welcome!, " + Name);
			 System.out.println("Click 1 to order clean service");
			 System.out.println("Click 2 to track your orders");
			 System.out.println("Click 3 if you want to delete any order you have been ordered");
			 System.out.println("Click 4 if you want to update any order you have been ordered");



			 press = scanner2.nextInt();
		
			 if(press == 1)//order
			 {
				 System.out.println("What do you want to clean");
				 System.out.println("press 1 for carpet, 2 for cover");
				 press = scanner2.nextInt();
				 
				 if(press == 1) {//carpet
					 category = "carpet";
				 }
				 else
					 category = "cover";
					 
				       System.out.println("Material: ");
			            material = scanner.nextLine();
						System.out.println("Color: ");
					     color = scanner.nextLine();
					     System.out.println("height: ");
					     height = scanner3.nextDouble();
					     System.out.println("width: ");
					     width = scanner3.nextDouble(); 
					   dimention = Double.toString(height) + "," + Double.toString(width);
					   
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
					     Q = scanner2.nextInt();
					     
					     CustomerProductnom = Product.getLastOrderNumber();
						 CustomerProductnom++; 
						

					 Product.create_Product(CustomerProductnom, id,dimention ,material,  color, category, payType, Q, picture ,  Product.calculatePrice(category, height, width, RST, Q) , 0 );
					 System.out.println("Are you sure you want this order");
					 System.out.println("press 1 for Yes");
					 System.out.println("press 2 for No");

				     press = scanner2.nextInt();
				     if(press == 1)
				    	 Product.AddProduct();
				     else if (press == 2)
				    	 return;
				    	 
					 
					 
				
			 }
			 
			 else if(press == 2)//track
			 {
				 
			    id = Customer.findIdByEmail(User);		    
				 Product.trackStatus(id);
				 
				
				 
				 
			 }
			 
			 else if(press == 3)//delete
			 {
				 System.out.println("which order do you want to delete? give me the number of your order(you can see it from tracking)");
				 System.out.println("press 1 to go to track");
				 System.out.println("press 2 to enter order number");
				 System.out.println("press 3 to return");

				 press = scanner2.nextInt();
				 if(press == 1)
				 {
					 id = Customer.findIdByEmail(User);		    
					 Product.trackStatus(id);
				 }
				 else if (press == 2)
				 {
				 System.out.println("Enter order number you want to delete");
				 number = scanner2.nextInt();
				 Product.deleteProduct(number);

				 }
				 else if (press == 3)
				 {
					 return;
				 }

			 }
			 
			 else if(press ==4)//update
			 
			 {
				 
				 UpdateOrder(scanner, scanner2, scanner3);
				 
			 }
			 
			 
	     }
	     else 
	    	 LOGGER.warning("Wrong user name or password, try again!");
	     }
	     else
	    	 return;
		
	}
	
	


	private static void UpdateOrder(Scanner scanner,Scanner scanner2,Scanner scanner3) {
	
		System.out.println("what order number do you want to update?");
		 number = scanner2.nextInt();

		 String row = Product.getRowByProductNumber(number);
		 if (row == null)
		     return;

		 String[] rowFile = row.split("\t");

		 System.out.println("do you want to update category?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     System.out.println("press 1 for carpet");
		     System.out.println("press 2 for cover");
		     press = scanner2.nextInt();
		     if (press == 1) {
		         category = "carpet";
		     } else {
		         category = "cover";
		     }
		 } else if (press == 2) {
		     category = rowFile[2];
		 }

		 System.out.println("do you want to update material?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     System.out.println("Enter material");
		     material = scanner.nextLine();
		     if (material.equalsIgnoreCase("wool")) {
		         RST = true;
		     }
		 } else if (press == 2) {
		     material = rowFile[3];
		     RST = Boolean.parseBoolean(rowFile[11]);
		 }

		 System.out.println("do you want to update color?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     System.out.println("Enter color");
		     color = scanner.nextLine();
		 } else if (press == 2) {
		     color = rowFile[4];
		 }

		 System.out.println("do you want to update dimension?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     System.out.println("Enter height");
		     height = scanner3.nextDouble();
		     
		     System.out.println("Enter width");
		     width = scanner3.nextDouble();
		     
		     dimention = Double.toString(height) + "," + Double.toString(width);
		 } else if (press == 2) {
		     dimention = rowFile[5];
		 }

		 System.out.println("do you want to update payment type?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     System.out.println("press 1 for Credit card");
		     System.out.println("press 2 for Cash");
		     press = scanner2.nextInt();
		     if (press == 1) {
		         payType = "Credit Card";
		     } else {
		         payType = "Cash";
		     }
		 } else if (press == 2) {
		     payType = rowFile[6];
		 }

		 System.out.println("do you want to update quantity?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     System.out.println("Enter quantity");
		     Q = scanner2.nextInt();
		 } else if (press == 2) {
		     Q = Integer.parseInt(rowFile[7]);
		 }

		 System.out.println("do you want to update picture?");
		 System.out.println(YESORNO);
		 press = scanner2.nextInt();
		 if (press == 1) {
		     Scanner s3 = new Scanner(System.in);
		     System.out.println("Enter picture");
		     picture = s3.nextLine();
		 } else if (press == 2) {
		     picture = rowFile[8];
		 }

		 Product.updateProduct(
		     CustomerProductnom,
		     rowFile[1],
		     category,
		     material,
		     color,
		     dimention,
		     payType,
		     Q,
		     picture,
		     rowFile[9],
		     rowFile[10],
		     Double.toString(Product.calculatePrice(category, height, width, RST, Q)), 0);

		
	}



	private static void signUp(Scanner scanner, Scanner scanner2, Scanner scanner3) {

		    
		    System.out.println("Id: ");
		    id = scanner.nextLine();
		    System.out.println("name: ");

		    Name = scanner.nextLine();
		    
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
		        Customer.create_customer(id, Name, phone, address, city, email, password, 0);
		        Customer.AddCustomer(FILENAME);
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
	    return username.equals(AdminName) && password.equals(AdminPass);	
	}
	
	
	
	
	
	}

	

