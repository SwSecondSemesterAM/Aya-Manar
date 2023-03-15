package testPackage;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import MyPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class discountFeature {
	
	public Customer customer;
	public String name;
	public static int amount;
	public int index=0 ,indexF=0;
    public Map<String, String>map ;
    

	
	@Given("these customers and those information")
	public void these_customers_and_those_information(io.cucumber.datatable.DataTable dataTable) {
	 
		map = new HashMap<String, String>();
	    map .putAll(dataTable.asMap()); 
	     
		
		
	}
	
	@Given("{string} uses the service with an amount of money > {int} NIS")
	public void uses_the_service_with_an_amount_of_money_nis(String customerName, Integer amountOfMoney) {
    customer = new Customer();
	amount = amountOfMoney; //400
	name = customerName; //like omar
	customer.setName(name);
	customer.setPayedMoney(4000);
	
	for(Map.Entry<String, String> entry : map.entrySet())
	{	
		String key = entry.getKey();//Aya
		if(key .equalsIgnoreCase("omar"))
		{
		String value = entry.getValue();//123
	    double m = Double.parseDouble(value);

	    if( m > 400)
		{  
			 indexF = 1; 
			break;
		}
	   
		}
		
	}
	
	
		
	}

	@When("the {string} frequently use this service with amount more than {int} NIS")
	public void the_frequently_use_this_service_with_amount_more_than_nis(String string, Integer int1) {
			 if(customer.get_payedMoney() > amount  && indexF ==1)
			 {	   customer.discount(customer.get_payedMoney());
			 index = 1;
				
			 }

	}
	


	@Then("then he have to get a <{int}>% discount")
	
	public void then_he_have_to_get_a_discount(Integer int1) {
	  
		assertTrue(index == 1);
		
	}

	
}
