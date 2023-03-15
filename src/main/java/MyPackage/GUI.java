package MyPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GUI {

	public static void main(String[] args) {
		int i;
		String s1,s2;
		Map<String, String> mapEx = new HashMap<String, String>() ;
		System.out.println("--------------------------------------------");
		System.out.println("|                                          |");
		System.out.println("| *feature1 : logIn                        |");
		System.out.println("|                                          |");
		System.out.println("| *feature2 : notify                       |");
		System.out.println("|                                          |");
		System.out.println("|  *feature3 : discount                    |");
		System.out.println("|                                          |");
		System.out.println("|  *feature4 : invoice                     |");
		System.out.println("|                                          |");
		System.out.println("|                                          |");
		System.out.println("--------------------------------------------");
		System.out.println("press number from 1 to 4 to see any of these features: ");
		Scanner sa = new Scanner(System.in);
		i = sa.nextInt();
		if(i == 1)
		{Customer c;
		Admin d = new Admin();
		System.out.println("Enter name aya ");
		s1 = sa.next();
		System.out.println("Enter  PASSWORD 123");
		s2 = sa.next();
		
		mapEx.putAll(d.getMap());
		for(Map.Entry<String, String> entry : mapEx.entrySet())
		{	
			String key = entry.getKey();//Aya
		    String value = entry.getValue();//123
	
		    if(key.equalsIgnoreCase(s1) && value.equalsIgnoreCase(s2))
			{  
				JOptionPane.showMessageDialog(null, "You Logged in!");
				break;
			}
		    else 
				JOptionPane.showMessageDialog(null, "wrong!");

		   

			
		}
		
		
		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		}

		


		
		
		

	}


