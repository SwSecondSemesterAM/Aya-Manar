package MyPackage;


public class Worker {

	private static boolean IsAvailable;
	private static String name;
	

	
	public static void setName(String name1) {

     name = name1;
		
	}

	public static void setAvailable(boolean b) {

	      IsAvailable = b;

	}



	public static boolean getAvailability() {
		return IsAvailable;
	}

	public static String getName() {

		return name;
	}

	


}