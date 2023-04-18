package testPackage;

import static org.junit.Assert.assertTrue;

import MyPackage.Admin;
import MyPackage.Customer;
import MyPackage.Product;
import MyPackage.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.messages.types.Product;

public class Notify {
	int test1 = 0;
	Customer c;
	String Name;
	Admin w;
	int i;

@Given("I want to send an email to {string}")
public void i_want_to_send_an_email_to(String name) {
	c = new Customer();
   Name = name;
   w = new Admin();
}

@When("the order is complete")
public void the_order_is_complete() {
	
	 
	//i = w.IsReady(test1);
//	System.out.print(test1);
}

@Then("I will send an email to Notify {string}")
public void i_will_send_an_email_to_notify(String string) {

assertTrue(i ==1);


}



}
