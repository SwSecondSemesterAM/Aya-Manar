package MyPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.System.Logger.Level;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class testAll {

	private static final int carpet = 40;
	private static final int cover = 45;
	private static String Name , phone , address , city , email , password ;
	//private static int Id;
	private static double CoverQ;
	private static double totalCover =0.0;
	private static double CarpetQ;
	private static double totalCarpet =0.0;
	private static double total;
	//private static String address;
	//private static String city;
	private static int i =0 ;
	private static double discount;
	private static double TotalDelivered;
	private static double TotalCash;
	private static double TotalPaid;
	private static double TotalDebts;
	private static String id;
	private static int indexId;
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

    private static final String FILENAME = "Customers.txt";
    private static final Logger LOGGER = Logger.getLogger(testAll.class.getName());


	public static void main(String[] args) {
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("Welcome to our application!");
		System.out.println("Press 1 to sign Up");
		System.out.println("Press 2 to logIn");
		press = scanner2.nextInt();
		
		if(press == 1)
		{
			Scanner scanner = new Scanner(System.in);

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

			
			if(press == 1)
			{
				 Customer.create_customer(id ,Name, phone, address, city,  email , password);
			        Customer.AddCustomer(FILENAME);
			}
			else
				return;
		    
		    
		 
		   
		}
		
		else if (press ==2 ) {
			
			 Scanner scanner = new Scanner(System.in);

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
		
		     if(flag == true )
		     {
		    	 Name = Customer.findNameByEmail(User);
				 System.out.println("Welcome!, " + Name);
				 System.out.println("Click 1 to order clean service");
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
						     height = scanner.nextDouble();
						     System.out.println("width: ");
						     width = scanner.nextDouble(); 
						   dimention = Double.toString(height) + "," + Double.toString(width);
						   
						   id = Customer.findIdByEmail(User);		    
						  
						     System.out.println("What method of payment will you be using?");
						     System.out.println("press 1 for Credit card");
						     System.out.println("press 2 for Cash");
						     press = scanner.nextInt();
						     if (press == 1)
						     {
						    	 payType = "Credit Card";
						     }
						     else
						    	 payType = "Cash";
						     
						     Scanner s = new Scanner(System.in);
						     System.out.println("Picture: ");
						     picture = s.nextLine();
						     System.out.println("Quantity: ");
						     Q = s.nextInt();
						     
						     CustomerProductnom = Product.getLastOrderNumber();
							 CustomerProductnom++; 
						   

						 Product.create_Product(CustomerProductnom, id,dimention ,material,  color, category, payType, Q, picture );
						 System.out.println("Are you sure you want this order");
						 System.out.println("press 1 for Yes");
						 System.out.println("press 2 for No");

					     press = scanner.nextInt();
					     if(press == 1)
					    	 Product.AddProduct();
					     else if (press == 2)
					    	 return;
					    	 
						 
						 
					
				 }
				 
				 
				 
				 
		     }
		     else 
		    	 LOGGER.warning("Wrong user name or password, try again!");
		     }
		     else
		    	 return;
		     
		}
		
	}
	
}

	

