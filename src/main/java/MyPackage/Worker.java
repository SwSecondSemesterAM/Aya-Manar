package MyPackage;

import java.util.Map;

public class Worker {

	private static boolean IsAvailable;
	private static String name;
	

	
	public static void setName(String name1) {

     name = name1;
		
	}

	public static void setAvailable(boolean b) {

	      IsAvailable = b;

	}

	public static void findAvailableWorker(Map<String, String> map) {
		for(Map.Entry<String, String> entry : map.entrySet())
		{	
			String key = entry.getKey();//omar
		    String value = entry.getValue();//true
	
		   
		    if(	value.equalsIgnoreCase("true"))
		    	{
		    	Worker.setAvailable(false);
		    	entry.setValue("false");
		
		    	break;
		    	}
		}
		    	
		
	}

	public static boolean getAvailability() {
		return IsAvailable;
	}

	public static String getName() {

		return name;
	}

	public static void findCorrespondigAvailability(Map<String, String> map) {

		for(Map.Entry<String, String> entry : map.entrySet())
		{	
			String key = entry.getKey();//omar
		    String value = entry.getValue();//true
	
		   
		    if(key.equalsIgnoreCase(Worker.getName()))
		    	{
		    	Worker.setAvailable(Boolean.getBoolean(value));
		    	break;
				
		    	}
		    
		}
		
	}



}