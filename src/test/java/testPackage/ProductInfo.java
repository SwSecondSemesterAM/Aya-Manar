package testPackage;

import static org.junit.Assert.assertEquals;

import MyPackage.Product;
import MyPackage.Test;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductInfo {
	
	
	Product p;
	boolean flag;
	String s;


	@When("click on insert button to insert information about product  and flag is {string}")
	public void click_on_insert_button_to_insert_information_about_product_and_flag_is(String string) {
		flag = Boolean.parseBoolean(string);
		p=new Product();
	  
	}

	@Then("the field {string} should be an error")
	public void the_field_should_be_an_error(String string) {
		System.out.println("Please enter information first!");
		assertEquals(false, flag);
	   
	}

	@When("Customer click on insert button to insert information about product and flag is {string}")
	public void customer_click_on_insert_button_to_insert_information_about_product_and_flag_is(String string) {
	   
	}

	@When("he fills {string} with {string}")
	public void he_fills_with(String string, String string2) {
		if(string.equalsIgnoreCase("Category"))
		{
			s = string;
			flag =  Test.checkName(string2);
			if (flag == true)
			{
				p.setCategory(string2);
			}
			else
			{
				assertEquals(false, flag);
				System.out.println(s+ " is worng! "+"Try again.");
			}
		}
		else if(string.equalsIgnoreCase("name"))
		{
			s = string;
			flag =  Test.checkName(string2);
			if (flag == true)
			{	p.setCategory(string2);
			
			}
			else
			{
				assertEquals(false, flag);
				System.out.println(s+ " is worng! "+"Try again.");
			}
		}
		
		else if(string.equalsIgnoreCase("Picture"))
		{
			s = string;
			flag =  Test.checkPicture(string2);
			if (flag == true)
				
			{	p.setPicture(string2);
			}
			else
			{
				assertEquals(false, flag);
				System.out.println(s+ " is worng! "+"Try again.");
			}

		}
		else if(string.equalsIgnoreCase("description"))
		{
			s = string;
			//flag =  Test.checkdescription(string2);
			if (flag == true)
			p.setdescription(string2);
			else
			{
				assertEquals(false, flag);
				System.out.println(s+ " is worng! "+"Try again.");
			}
		}
		else if(string.equalsIgnoreCase(" Isrequiredspecialtreatment"))
		{
			s = string;
			flag =  Test.checkIsrequiredspecialtreatment(flag);
			if (flag == true)
			p.setIsrequiredspecialtreatment(flag);
			else
			{
				assertEquals(false, flag);
				System.out.println(s+ " is worng! "+"Try again.");
			}
		}
		
		

		}
		
		

		
	

	@Then("he will fill information sucessfully.")
	public void he_will_fill_information_sucessfully() {
	    
		assertEquals(true, flag);
		System.out.println("inserted succfuly!");
	}

	@When("Customer click on insert button to SignUp to this application and flag is {string}")
	public void customer_click_on_insert_button_to_sign_up_to_this_application_and_flag_is(String string) {
	   
	}

	@Then("he will see a {string} tells that there is something error with his input")
	public void he_will_see_a_tells_that_there_is_something_error_with_his_input(String string) {
	    
	}


}
