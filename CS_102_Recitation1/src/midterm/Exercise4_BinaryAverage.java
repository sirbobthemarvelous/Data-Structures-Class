package midterm;


public class Exercise4_BinaryAverage {
	public static void main(String[] args) {
		int [] set = {5,2,6,3};
		System.out.println(5/2);
		System.out.println(Math.ceil(5/2.0));
		//checking if the floor ceiling still works
		
		System.out.println(BinaryAverage(set,0,4));
		
	}

	public static double BinaryAverage(int[] arr, int index, int len) {
		if(len == 1) { //base case you find each individual element
			System.out.println(arr[index]);
			return arr[index];
		}
		else {
			//calling the binary recursion while multiplying it by the number of elements it contains
			double first = BinaryAverage(arr, index, len/2)*(len/2);
			double second = BinaryAverage(arr, index+(len/2), (int)Math.ceil(len/2.0))*((int)Math.ceil(len/2.0));
			//then divide the total number of elements in the end
			return (first + second)/len;
			}
		}
	}
