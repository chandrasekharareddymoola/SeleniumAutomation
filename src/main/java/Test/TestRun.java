package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestRun {

	public static void main(String[] args) {
		for(int j=0; j<10;j++) {
			int MinE = 0;
			int MaxE = 3;
			int RandomE = (MinE) + (int)(Math.random()*( MaxE - MinE + 1));
			System.out.println(RandomE);
		}
	}
}
