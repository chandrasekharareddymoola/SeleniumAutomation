package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRun {

	public static void main(String[] args) {
		List<String>  OriginalList = new ArrayList<String>();
		List<String>  TempList = new ArrayList<String>();
		OriginalList.add("Name");
		OriginalList.add("Text");
		OriginalList.add("Contact");
		OriginalList.add("vulcano");
		OriginalList.add("Name2");
		System.out.println(OriginalList);
		System.out.println("\n space \n");
		TempList.addAll(OriginalList);
		System.out.println(TempList);
		Collections.sort(TempList);
		System.out.println("\n space \n");
		System.out.println(TempList);
	}

}
