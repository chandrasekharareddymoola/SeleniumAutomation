package com.eagle.Base;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.eagle.PageFactory.PageFactory;



public class TestBase extends BasePage {
	
	static String[] exceldata = null;
	static String data = new String();
	static List<String> keywordResult = new ArrayList<>();
	static List<String> testResult = new ArrayList<>();
	public static Method method[];
	public static Object keyword;
	public static String getAction;
	public static String currentobject;
	
	public static void main(String[] args) throws Exception {

		keyword = new BasePage();
		PageFactory.oldobject="basepage";
		method = keyword.getClass().getMethods();
		String spath = "./Resources/TestCases.xlsx";
		exceldata = ReadKeywords.readKeyword(spath);
		int row = exceldata.length;
		long[] time = new long[row];
		for (row = 1; row < exceldata.length; row++) {
			data = ReadKeywords.getInputParameters(spath, row);
			getAction = exceldata[row];
			if (getAction.equals("empty")) {
				keywordResult.add(" ");
				time[row - 1] = System.currentTimeMillis();
				// System.out.println(time[row-1]);
			} else {
				execute_Actions();
				Thread.sleep(1000);
				currentobject=PageFactory.getObject(driver.getCurrentUrl());
				if(!PageFactory.oldobject.equals(currentobject))
				{
					keyword=PageFactory.setObject(currentobject);
					method = keyword.getClass().getMethods();
					PageFactory.oldobject=currentobject;
				}
			}
		}

		//ReadKeywords.writeResult(keywordResult, time);
	}
	/*
	 * @AfterTest public static void close() { driver.quit(); }
	 */
	public static void execute_Actions() throws Exception {
		for (int i = 0; i < method.length; i++) {

			if (method[i].getName().equalsIgnoreCase(getAction)) {
				try {
						if (data.equals(""))
							method[i].invoke(keyword);
						else
							method[i].invoke(keyword, data);
					keywordResult.add("PASSED");					
					break;
				} catch (Exception e) {
	                  
					keywordResult.add("FAILED");
				}
			}
			if(i==method.length-1)
				System.out.println(getAction);
		}

	}

}
