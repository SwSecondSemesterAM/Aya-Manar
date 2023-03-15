package testPackage;

import static org.junit.Assert.assertTrue;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import MyPackage.Admin;
import MyPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogIn_feature {

	public  String keyEx = "Aya", valueEx ="123";
    public Customer c;

	public ArrayList<String> name;
	public ArrayList<String> password;
	public Map<String, String>map ;
    public Map<String, String> mapEx = new HashMap<String, String>();
 
	@Given("these customers names and their passwords are contained in the system")
	public void these_customers_names_and_their_passwords_are_contained_in_the_system( io.cucumber.datatable.DataTable dataTable) {
		   map = new HashMap<String, String>();
	       map .putAll(dataTable.asMap()); 
	    
	     
	}
	
	
	@Given("the {string} enter his name and his password correctly")
	public void the_enter_his_name_and_his_password_correctly(String customer) 
	{
		c = new Customer();
		
		c.setName(customer);
		
	}
	
	@When("he press logIn")
	
	public void he_press_log_in() {
		
		for(Map.Entry<String, String> entry : map.entrySet())
		{	
			String key = entry.getKey();//Aya
		    String value = entry.getValue();//123
	
		    if(key.equalsIgnoreCase(keyEx))
			{  
		    if(	value.equalsIgnoreCase(valueEx))
		    	{
				c.setCustomerLogedIn();
				break;
		    	}
		    
			}
		   
		}
		
	//	System.out.print(map.entrySet());
	}

	@Then("his profile will open")
	public void his_profile_will_open() {
		

		
		assertTrue(c.getCustomerloged());
		//String element1 = (String) map.get("key1");

		
	}

	@Given("the {string} enter his password wrong")
	public void the_enter_his_password_wrong(String name) {
		c = new Customer();
		c.setName(name);
		
		
		for(Map.Entry<String, String> entry : map.entrySet())
		{	
			String key = entry.getKey();
		    String value = entry.getValue();
	
		    if(key.equalsIgnoreCase(keyEx) && value.equalsIgnoreCase(valueEx))
			{  
				c.setCustomerLogedIn(); 
				break;
			}
		   

			
		}
		

	}

	@Then("A message will appear saying that the password was entered incorrectly")
	public void a_message_will_appear_saying_that_the_password_was_entered_incorrectly() {
		
		assertTrue(c.getCustomerloged());

	}


}
