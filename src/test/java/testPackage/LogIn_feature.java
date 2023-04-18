package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

	public  String keyEx = "yasmeen", valueEx ="5466";
    boolean flag;


	public Map<String, String>map ;
 
	@Given("these customers names and their passwords are contained in the system")
	public void these_customers_names_and_their_passwords_are_contained_in_the_system( io.cucumber.datatable.DataTable dataTable) {
		   map = new HashMap<String, String>();
	       map .putAll(dataTable.asMap()); 
	    
	     
	}
	
	
	
	
	
		
	//	System.out.print(map.entrySet());

	


	@Given("{string} enter his name and his password correctly")
	public void enter_his_name_and_his_password_correctly(String customer) {
	  
		Customer.setName(customer);
		
	}
	
@When("he press logIn")
	
	public void he_press_log_in() {
		
		for(Map.Entry<String, String> entry : map.entrySet())
		{	
			String key = entry.getKey();//Aya
		    String value = entry.getValue();//123
	
		    if(key.equalsIgnoreCase(Customer.get_name()))
			{  
		    if(	value.equalsIgnoreCase(Customer.get_password()))
		    	{
		    	Customer.setCustomerLogedIn();
				break;
		    	}
		    
			}
		   
		}
}

@Then("his profile will open")
public void his_profile_will_open() {
	

	
	assertTrue(Customer.getCustomerloged());
	//String element1 = (String) map.get("key1");

	
}

@Given("{string} enter his {string} wrong")

public void enter_his_wrong(String name, String pass) {
		
		Customer.setName(name);
		Customer.setPassword(pass);
			
			
			for(Map.Entry<String, String> entry : map.entrySet())
			{	
				String key = entry.getKey();
			    String value = entry.getValue();
		
			    if(key.equalsIgnoreCase(Customer.get_name()) && value.equalsIgnoreCase(Customer.get_name()))
				{  
			    	Customer.setCustomerLogedIn(); 
					break;
				}
			   

				
			}
	}

	@Then("A message will appear saying that {string}")
	public void a_message_will_appear_saying_that(String string) {
		////checking

		assertFalse(Customer.getCustomerloged());
		System.out.println(string);


	}

	@Given("Customer click on login and flag is {string}")
	public void customer_click_on_login_and_flag_is(String string) {
		 flag = true;
		
	   
	}

	@When("field {string} empty")
	public void field_empty(String string) {
		
	    
		if(Customer.get_name().isEmpty())
		{
			flag = false;
			
		}
		
	
			
		
			
		 
 		
		
		
	}

	@When("field 'password'empty")
	public void field_password_empty() {
		 if(Customer.get_password().isEmpty())
			{
				flag = false;
			}
	   
	}

	@Then("an error message will show {string}")
	public void an_error_message_will_show(String string) {
		
		 assertEquals(flag, true);
		 System.out.println(string);
		 
	   
	}
	
	
	
}
