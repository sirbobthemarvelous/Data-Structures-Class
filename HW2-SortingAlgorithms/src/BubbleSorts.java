
public class BubbleSorts {

	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		int [] result2 = BubbleSortR(set);
		int [] result = BubbleSortN(set);

		for(int i: result2) { //print out the elements 
			System.out.println(i);
		}
		for(int j: result) { //print out the elements after being sorted
			System.out.println(j);
		}
		
	}
	public static int[] BubbleSortN(int[] arr) { //non recursive implementation
		int count = 0;
		do {
			count = 0;
			for(int i=0; i< arr.length-1; i++) {
				if(arr[i] > arr[i+1]) { //if they're not in order, swap them
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++; //and show that an edit has been made
				}
			}
		}while(count != 0);
		return arr;
	}
	public static int[] BubbleSortR(int[] arr) { //recursive implementation
		int count = 0;
		for(int i=0; i< arr.length-1; i++) {
			if(arr[i] > arr[i+1]) { //if they're not in order, swap them
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
				count++; //and show that an edit has been made
			}
		}
		if(count != 0) {
			return BubbleSortR(arr);
		}
		else {
		return arr;
		}
	}
}
