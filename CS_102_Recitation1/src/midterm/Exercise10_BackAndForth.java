package midterm;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Exercise10_BackAndForth {
	public static void main(String[] args) {
		System.out.println(134%10);
		System.out.println(Math.pow(10,3));
		//checking if the floor ceiling still works
		
		System.out.println(PallandromeNum(15,0,1)); //false case
		System.out.println(PallandromeNum(15351,0,4));//true case
		
	}
	

	public static boolean PallandromeNum(int num, int low, int high) {

		if(low<high) {
			BigInteger lower = BigDecimal.valueOf((num/Math.pow(10, low))%10).toBigInteger();
			BigInteger higher = BigDecimal.valueOf((num/Math.pow(10, high))%10).toBigInteger();
			if(lower.equals(higher)) { 
				//checking the value of corresponding digits
				System.out.println((num/Math.pow(10, low))%10);
				System.out.println((num/Math.pow(10, high))%10);
				low++;
				high--;
				return PallandromeNum(num,low,high);
			}
			else { //in the event that it isn't symmetric
				return false;
			}	
		}
		else { //you've finished your recursion
			return true;
		}
		
	}
}
