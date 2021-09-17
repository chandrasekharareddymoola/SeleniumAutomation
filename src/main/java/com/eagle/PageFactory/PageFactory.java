package com.eagle.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

import com.eagle.pages.InvestigationPage;
import com.eagle.pages.LoginPage;

public class PageFactory {
	
	public static String oldobject;
	private static Map<String,String> map;
	
	
	static {
		map = new LinkedHashMap<>();
		map.put("/login", "login");
		map.put("/Dashboard", "home");
		map.put("/UserWorkspace/Investigations", "investigation");	
		
	}
	
	public static String getObject(String data) throws Exception {
		
		Object[] key = map.keySet().toArray();
		for (Object obj : key) {
			if (data.contains(obj.toString()))
				return map.get(obj.toString());		    
	    }
		return oldobject;	
	}
	
	public static Object setObject(String data) throws Exception {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();

		// Add mappings using put method
		
		//map.put("login", new LoginPage());
		//map.put("panel", new InvestigationPage());	
		
		return map.get(data);

	}

}
