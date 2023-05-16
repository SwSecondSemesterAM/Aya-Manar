package testPackage;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myPackage.Customer;

public class LogOutFeature {

String name ;	
@Given("{string} has signed up to the app")
public void has_signed_up_to_the_app(String Name) {

name = Name;
Customer.setName(Name);
}

@Given("he is now in his profile")
public void he_is_now_in_his_profile() {

	Customer.setCustomerLogedIn();
	
}

@When("he presses on logOut")
public void he_presses_on_log_out() {

	Customer.setCustomerLogedOut();
	
}

@Then("he will return to logIn page")
public void he_will_return_to_log_in_page() {
 assertTrue(Customer.getCustomerloged() == false );

	
}

	
	
	
	
}
