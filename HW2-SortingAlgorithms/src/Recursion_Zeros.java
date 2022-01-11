
public class Recursion_Zeros {

	public static void main(String[] args) {
		for(int i = 0; i<65; i++) {
			System.out.println(Zeros(i));
		}
	}
	

	public static int Zeros(int num) {
		if(num ==0) { //in the event its just a 0
			return 1;
		}
		if(num ==1) { //base case where the largest value of 2^k below n is found
			return 0;
		}
		if(num%2 ==0) { //see if its got a zero at this level or not
			return 1+Zeros(num/2);
		}
		else {
			num--;
			return Zeros(num/2);
		}

	}
}
