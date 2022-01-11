
public class QuickSort { //You need to revisit this, and edit PARTITION
	public static void main(String[] args) {
		int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
		quick(set,0,15);

		for(int i: set) { //print out the elements 
			System.out.println(i);
		}
		
	}
	public static void quick(int[] arr, int low, int high) {
        if (low < high) {
        	int location = partition(arr, low ,high);
        	
        	quick(arr, low, location-1);
            quick(arr, location+1, high);
        }
       
	}

	public static int partition(int[] arr, int low, int high) {
		int highestEl = arr[high]; 
        int lower = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot which is arr[high]
            if (arr[j] <= highestEl)
            {
            	lower++;
  
                // swap arr[lower] and arr[j]
                int temp = arr[lower];
                arr[lower] = arr[j];
                arr[j] = temp;
            }
        }
  
        // swap arr[lower+1] and arr[high] aka highestEl
        int temp = arr[lower+1];
        arr[lower+1] = arr[high];
        arr[high] = temp;
  
        return lower+1;
	}
}
