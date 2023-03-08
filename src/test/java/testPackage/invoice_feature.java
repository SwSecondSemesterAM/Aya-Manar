package testPackage;

import static org.junit.Assert.assertTrue;

import javax.swing.JOptionPane;

import MyPackage.Customer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invoice_feature {

	public String Name = "manar";
	public int id = 1232;
	public int phone = 234342;
	public String address = "T_64e3";
	public String password = "1243";
	public double Money = 1000;
	public Customer customer;	
	public int i =0;


@Given("{string} has already logged_In")
public void has_already_logged_in(String name) {
	Name =name;
	customer = new Customer();
	JOptionPane.showMessageDialog(null, "your request is ready now, fill your invoice information");


}


	@When("{string} requests the service")
	public void requests_the_service(String string) {
		

	customer.set_id(id);
	customer.setAddress(address);
	customer.setName(Name);
	customer.setPassword(password);
	customer.setPayedMoney(Money);
	customer.setPhone(phone);
	JOptionPane.showMessageDialog(null, "Generate your invoice successfully");
	i =1;
		
	}

	@Then("should generate invoice")
	public void should_generate_invoice() {
	assertTrue ( i ==1);
		
	}
	
	
	
	
	
	
	
	
}
