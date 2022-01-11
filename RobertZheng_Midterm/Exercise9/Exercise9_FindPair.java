
import java.util.ArrayList;

public class Exercise9_FindPair {
	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		System.out.println(5/2);
		System.out.println(Math.ceil(5/2.0));
		//checking if the floor ceiling still works

		lessEfficient(set);
		moreEfficient(set);
		
	}
	public static void lessEfficient(int[] set) { //runtime is O(n^3)
		int [] result2 = SelectionSort(set); //selection sort has a runtime of O(n^2)
		for(int i: result2) { //print out the elements from the resulting selection sort
			System.out.println(i);
		}
		ArrayList<int[]> pairs2 = pairFinder(result2); //pairfinder has a runtime of O(n)
		for(int[] p: pairs2) { //print out the pairs
			System.out.println(p.toString());
		}
		//O(n) * O(n^2) is O(n^3)
	}
	public static void moreEfficient(int[] set) { //runtime is O(n^2log(n))
		int [] result = BinarySort(set,0,16); //Binary Sort has a runtime of O(nLog(n))
		for(int i: result) { //print out the elements from the resulting binary merge sort
			System.out.println(i);
		}
		ArrayList<int[]> pairs = pairFinder(result); //pairfinder has a runtime of O(n)
		for(int[] p: pairs) { //print out the pairs
			System.out.println(p.toString());
		}
		//O(n) * O(nLog(n)) is O(n^2Log(n))
	}
	public static ArrayList<int[]> pairFinder(int[] arr) { //runtime O(n)
		ArrayList<int[]> pairs = new ArrayList<int[]>();
		if(arr.length <2) {
			pairs.add(arr);
			return pairs;
		}
		int smallest = arr[0]-arr[1];  //the upcoming loop iterates for n-1 times, equivalent to O(n)
		for(int i=0; i< arr.length-1; i++) { //checking the distances between elements
			int difference = Math.abs(arr[i]-arr[i+1]);
			if(difference < smallest) {
				smallest = difference;
			}
		}
		//even though I have 2 of these loops that iterate for n-1 times, 2(n-1) still ends up as O(n) since 2 is a constant not an exponent
		for(int i=0; i< arr.length-1; i++) { //to doublecheck for multiple Closest Pairs
			int difference = Math.abs(arr[i]-arr[i+1]);
			if(difference == smallest) {
				int[] winner = {arr[i],arr[i+1]};
				pairs.add(winner);
			}
		}
		return pairs;
	}
	public static int[] SelectionSort(int[] arr) { //runtime is O(n^2)
		for(int i=0; i< arr.length; i++) {
			int smallest = i;
			for(int j=i; j<arr.length;j++) { //two for loops both based on the length of the array
				if(arr[j]<arr[smallest]) {   //Add a third loop to go through the array to find the pairs and you get O(n^3)
					smallest = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
		return arr;
	}
	//maybe add a method to this whole thing? to actually find the pair?
	
	public static int[] BinarySort(int[] arr, int index, int len) { //runtime is O(log(n))
		if(len == 1) { //base case you find each individual element
			int [] piece = {arr[index]};
			return piece;
		}
		else {
			//calling the binary recursion while multiplying it by the number of elements it contains
			int[] first = BinarySort(arr, index, len/2);
			int[] second = BinarySort(arr, index+(len/2), (int)Math.ceil(len/2.0)); //Binary Recursion is O(log(n))
			//then divide the total number of elements in the end
			return merge(first,second);												//Multiply that with
			}
	}
	public static int[] merge(int[] arr, int[] arr2) { //runtime is O(n)
		int index = 0;
		int index2 = 0;
		int index3 = 0;
		int [] combo = new int[arr.length+arr2.length];
		//two for loops 
		while(index < arr.length && index2 < arr2.length) {// This loop is ultimately n+n iterations, which falls under O(n)
			//compare which is lower
			if(arr[index] < arr2[index2]) {
				combo[index3] = arr[index];
				index++;
				index3++;
			}
			else {
				combo[index3] = arr2[index2];
				index2++;
				index3++;
			}
			//in the event that you reach the end of one array
			while(index < arr.length && index2 == arr2.length) {
				combo[index3] = arr[index];
				index++;
				index3++;
			}
			while(index == arr.length && index2 < arr2.length) {
				combo[index3] = arr2[index2];
				index2++;
				index3++;
			}
		}
		return combo;
	}

}
