
public class Exercise1_ReversedTest {

public static void main(String[] args) {
	
		System.out.println(ReversedTest("google", "elgoog")); //true case
		System.out.println(ReversedTest("data","ata"));//false case
		System.out.println(ReversedTest("data","data"));//false case
		
	}
	

	public static int ReversedTest(String first, String second) { //Runtime O(n)

		//remove all whitespace
		first = first.replaceAll("\\s", "");
		second = second.replaceAll("\\s", "");
		//convert it to all uppercase (ignoring case in this exercise)
		first = first.toUpperCase();
		second = second.toUpperCase();
		
		// if they still have different lengths after this, they're not pallandromes
		if(first.length() != second.length()) { 
			System.out.println("different lengths");
			return 0;
		}
		char[] fir = first.toCharArray();
		char[] sec = second.toCharArray();
		//go through the string to check each character
		
		int j = second.length()-1;
		for(int i = 0; i < first.length(); i++) {
			if(fir[i] != sec[j]) {
				return 0;
			}
			j--;
		}
		//if it passes through this gauntlet of comparison with no issues, it is a pallandrome
		return 1;
	}
}
