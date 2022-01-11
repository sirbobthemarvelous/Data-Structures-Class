
public class Exercise7_BinarySort {
	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		System.out.println(5/2);
		System.out.println(Math.ceil(5/2.0));
		//checking if the floor ceiling still works
		int [] result = BinarySort(set,0,16);
		
		for(int i: result) { //print out the elements on the merge
			System.out.println(i);
		}
		
	}

	public static int[] BinarySort(int[] arr, int index, int len) {
		if(len == 1) { //base case you find each individual element
			System.out.println(arr[index]);
			int [] piece = {arr[index]};
			return piece;
		}
		else {
			//calling the binary recursion while multiplying it by the number of elements it contains
			int[] first = BinarySort(arr, index, len/2);
			int[] second = BinarySort(arr, index+(len/2), (int)Math.ceil(len/2.0));
			//then divide the total number of elements in the end
			return merge(first,second);
			}
	}
	public static int[] merge(int[] arr, int[] arr2) {
		int index = 0;
		int index2 = 0;
		int index3 = 0;
		int [] combo = new int[arr.length+arr2.length];
		//two for loops 
		while(index < arr.length && index2 < arr2.length) {
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
