
public class PallandromeCheck {
	public static void main(String[] args) {
		
		System.out.println(PallandromeTest("google")); //false case
		System.out.println(PallandromeTest("data"));//false case
		System.out.println(PallandromeTest("dad")); //true case
		System.out.println(PallandromeTest("kayak")); //true case
		
	}
	

	public static boolean PallandromeTest(String word) { //Runtime O(n)

		if(word.length()==1 ||word.length()==0) { //obvious case
			return true;
		}

		if(word.charAt(0) == word.charAt(word.length()-1)) { //check same character at begginning and end
			word = word.substring(1,word.length()-1); //substring without beggining and end
			return PallandromeTest(word);
		}
		else {
			return false; //if at anypoint it isn't, it isn't a pallandrome
		}
	}
}
