
public class SelectionSort { 

	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		int [] result2 = selectionSort(set);

		for(int i: result2) { //print out the elements 
			System.out.println(i);
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
}
