package testPackage;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import MyPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class discountFeature {
	
	public Customer customer;
	public String name;
	public static int amount;
	public int no_Time;
	int money = 800;
    
	
	@Given("{string} uses the service with an amount of money > {int} NIS")
	public void uses_the_service_with_an_amount_of_money_nis(String customerName, Integer amountOfMoney) {
    
	amount = amountOfMoney; //400
	name = customerName; //like omar
	no_Time ++;
		
	}

	@When("the {string} frequently use this service with amount more than {int} NIS")
	public void the_frequently_use_this_service_with_amount_more_than_nis(String string, Integer int1) {
		 if(no_Time > 4) {//if he use it more than 4 times he will take discount
			 
				customer.discount();//??
				
		 }

	}
	


	@Then("then he have to get a <{int}>% discount")
	
	public void then_he_have_to_get_a_discount(Integer int1) {
	  
		assertTrue(money > 400);
		
	}

	
	
	
	

}
