package testPackage;

import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;

import MyPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invoice_feature {
	/*
	  including delivery information price , address , items he
	give to clean
	*/
		
	public String Name ;
	public int id = 1232;
	public int phone = 234342;
	public String address = "T_64e3";
	public String password = "1243";
	public double Money = 1000;
	public Customer customer;	
	public int i =0;
	@Given("{string} has already logged_In to his profile")
	public void has_already_logged_in_to_his_profile(String name) {

		Name =name;
		customer = new Customer();
		customer.setCustomerLogedIn();
	}

	@Given("he requests the service")
	public void he_requests_the_service() {
		
	customer.set_request_the_service();
		
	}

	@When("the service done")
	public void the_service_done() {
	  customer.set_customer_service_done();
	}

	@Then("an invoice should generate for him")
	public void an_invoice_should_generate_for_him() {
		
	System.out.println(customer.get_items() + customer.get_name() + customer.get_payedMoney() +customer.get_id());
	 //not sure  
	}

	
	
}
