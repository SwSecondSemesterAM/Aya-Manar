package testPackage;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myPackage.Product;
import myPackage.Test;

public class ProductInfo {
	
	
	boolean flag;
	String s;
    private static final Logger LOGGER = Logger.getLogger(ProductInfo.class.getName());
	public static final String WRONG = " is wrong! Try again ";

	@When("click on insert button to insert information about product  and flag is {string}")
	public void click_on_insert_button_to_insert_information_about_product_and_flag_is(String string) {
		flag = Boolean.parseBoolean(string);
	  
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
	    s = string;
	    switch (string.toLowerCase()) {
	        case "category":
	        case "name":
	            flag = Test.checkCategory(string2);
	            if (flag) {
	                Product.setCategory(string2);
	            } else {
	                assertEquals(false, flag);
	                LOGGER.warning(s + WRONG);
	            }
	            break;
	        case "picture":
	            flag = Test.checkPicture(string2);
	            if (flag) {
	            	Product.setPicture(string2);
	            } else {
	                assertEquals(false, flag);
	                LOGGER.warning(s + WRONG );
	            }
	            break;
	        case "description":
	            // flag = Test.checkdescription(string2);
	            if (flag) {
	            	//Product.setdescription(string2);
	            } else {
	                assertEquals(false, flag);
	                LOGGER.warning(s + WRONG );
	            } 
	            break;
	        case "isrequiredspecialtreatment":
	            flag = Test.checkIsRequiredSpecialTreatment(flag);
	            if (flag) {
	            	Product.setIsrequiredSpecialTreatment(flag);
	            } else {
	                assertEquals(false, flag);
	                LOGGER.warning(s + WRONG );
	            }
	            break;
	        default:
	        	LOGGER.warning("Unknown string: " + string);
	            break;
	    }
	

	    switch(string.toLowerCase()) {
	    case "category":
	        s = string;
	        flag = Test.checkCategory(string2);
	        if (flag) {
	            Product.setCategory(string2);
	        } else {
	            assertEquals(false, flag);
	            LOGGER.warning(s + WRONG);
	        }
	        break;
	    case "name":
	        s = string;
	        flag = Test.checkCategory(string2);
	        if (flag) {
	            Product.setCategory(string2);
	        } else {
	            assertEquals(false, flag);
	            LOGGER.warning(s + WRONG);
	        }
	        break;
	    case "picture":
	        s = string;
	        flag = Test.checkPicture(string2);
	        if (flag) {
	            Product.setPicture(string2);
	        } else {
	            assertEquals(false, flag);
	            LOGGER.warning(s + WRONG);
	        }
	        break;
	    case "description":
	        s = string;
	        if (flag) {
	       //     Product.setdescription(string2);
	        } else {
	            assertEquals(false, flag);
	            LOGGER.warning(s + WRONG);
	        }
	        break;
	    case "isrequiredspecialtreatment":
	        s = string;
	        flag = Test.checkIsRequiredSpecialTreatment(flag);
	        if (flag) {
	            Product.setIsrequiredSpecialTreatment(flag);
	        } else {
	            assertEquals(false, flag);
	            LOGGER.warning(s + WRONG);
	        }
	        break;
	}

		
	}
		
		
		

		
	

	@Then("he will fill information sucessfully.")
	public void he_will_fill_information_sucessfully() {
	    
		assertEquals(true, flag);
		LOGGER.info("inserted successfuly!");
	}

	@When("Customer click on insert button to SignUp to this application and flag is {string}")
	public void customer_click_on_insert_button_to_sign_up_to_this_application_and_flag_is(String string) {
	   
	}

	@Then("he will see a {string} tells that there is something error with his input")
	public void he_will_see_a_tells_that_there_is_something_error_with_his_input(String string) {
	    
	}


}
