package testPackage;

import static org.junit.Assert.assertTrue;

import MyPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutFeature {

String name ;	
Customer c ;
@Given("{string} has signed up to the app")
public void has_signed_up_to_the_app(String Name) {
c = new Customer();
name = Name;
c.setName(Name);
}

@Given("he is now in his profile")
public void he_is_now_in_his_profile() {

c.setCustomerLogedIn();
	
}

@When("he presses on logOut")
public void he_presses_on_log_out() {

c.setCustomerLogedOut();
	
}

@Then("he will return to logIn page")
public void he_will_return_to_log_in_page() {
 assertTrue(c.getCustomerloged() == false );

	
}

	
	
	
	
}
