package testPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import MyPackage.Customer;
import MyPackage.Product;
import MyPackage.Worker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class distributeFeature {

	public Map<String, String>map ;
	public ArrayList<String > order;
	public ArrayList<String> All_workers_Availabilty;
	public boolean flag =  true;

	
	
	String worker = "omar";
	String available = "true";
	
	@Given("these worker names are contained in the system")
	public void these_worker_names_are_contained_in_the_system(io.cucumber.datatable.DataTable dataTable) {
		  map = new HashMap<String, String>();
		  All_workers_Availabilty = new ArrayList<>();
	       map .putAll(dataTable.asMap());
	       All_workers_Availabilty.addAll(dataTable.column(1));
	}

	@Given("these order names are contained in the system")
	public void these_order_names_are_contained_in_the_system(io.cucumber.datatable.DataTable dataTable) {
	   order = new ArrayList<>();
	   order.addAll(dataTable.asList());

	}
	   
	   @Given("there is {string} needs {string} to receive")
	   public void there_is_needs_to_receive(String product, String name) {
		//worker name
		Worker.setName(name);
        Worker.findCorrespondigAvailability(map);
		/*for(Map.Entry<String, String> entry : map.entrySet())
		{	
			String key = entry.getKey();//omar
		    String value = entry.getValue();//true
	
		   
		    if(key.equalsIgnoreCase(Worker.getName()))
		    	{
		    	Worker.setAvailable(Boolean.getBoolean(value));
		    	break;
				
		    	}
		    
		}	*/  
		
		

	}


	
	@When("there is {string} available")
	public void there_is_available(String string) {

		Worker.findAvailableWorker(map);
		
		

	}
	


	@Then("he will take this {string}")
	public void he_will_take_this(String string) {
		
      assertFalse(Worker.getAvailability());   
	}
	@Given("there is orders needs {string} to receive")
	public void there_is_orders_needs_to_receive(String name) {
		Worker.setName(name);

	}

	@When("there is no available workers")
	public void there_is_no_available_workers() {
	   
		for(String s : All_workers_Availabilty)
		{
			if(s.equalsIgnoreCase("false"))
			{
				flag = false;
			}
		}
	}

	@Then("No one will take the order")
	public void no_one_will_take_the_order() {
		
		assertFalse(flag);


	}
	
	
}