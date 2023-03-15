package MyPackage;

import java.util.Map;

public class Admin {
	private Map<String, String> map;

	
	public int IsReady(int test)
	{
		System.out.print("hi");
		return test+1;
		
	}
	

public void setMap(Map<String, String> map) {

	this.map .putAll(map);
	
}
public Map<String, String> getMap()
{
	return map;
	
}

}
