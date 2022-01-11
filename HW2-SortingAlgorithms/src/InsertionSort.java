
public class InsertionSort {

	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		insertionSort(set);

		for(int i: set) { //print out the elements 
			System.out.println(i);
		}
		
	}
	public static void insertionSort(int[] arr) {
        for (int i=1; i< arr.length; i++)
        {
            int key = arr[i];
            int j = i-1;
  
            /* Move elements of arr that are greater than key, 
             * to one position ahead
               of their current position*/ 
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j]; //Shift or swap them ahead to make room
                j = j-1;
            }
            arr[j+1] = key; //either stays in the same place or 
        }
	}
	
	
}
