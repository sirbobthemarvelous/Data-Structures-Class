
public class Exercise6_merge {
	public static void main(String[] args) {
		int [] set = {2,4,6,8,10,12,14,16,50,60,70,80};
		int [] set2 = {1,4,12,15,23, 24};
		int [] result = merge(set,set2);
		
		for(int i: result) { //print out the elements on the merge
			System.out.println(i);
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
