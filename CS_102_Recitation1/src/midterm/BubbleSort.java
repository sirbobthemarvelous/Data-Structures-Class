package midterm;

public class BubbleSort {

	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		int [] result2 = selectionSort(set);
		int [] result = binarySelectionSort(set);

		for(int i: result2) { //print out the elements 
			System.out.println(i);
		}
		for(int j: result) { //print out the elements after being sorted
			System.out.println(j);
		}
		
	}
	public static int[] selectionSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			int smallest = i;
			for(int j=i; j<arr.length;j++) {
				if(arr[j]<arr[smallest]) {
					smallest = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
		return arr;
	}
	public static int[] binarySelectionSort(int[] arr) {
		for(int i=0; i< arr.length; i++) {
			int smallest = BinaryMin(arr, i, arr.length-1);
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
		return arr;
	}
	public static int BinaryMin(int[] arr, int index, int len) {
		if(len == 1) {
			System.out.println(arr[index]);
			return arr[index];
		}
		else {
			int first = BinaryMin(arr, index, len/2);
			int second = BinaryMin(arr, index+(len/2), (int)Math.ceil(len/2.0));
			if(first < second){
				System.out.println(first);
				return first;
			}
			else {
				System.out.println(second);
				return second;
			}
		}
	}
}
