package midterm;



public class Exercise1_BinaryMax {
	public static void main(String[] args) {
		int [] set = {5,2,6,3};
		System.out.println(5/2);
		System.out.println(Math.ceil(5/2.0));
		//checking if the floor ceiling still works
		
		System.out.println(BinaryMax(set,0,4));
		
	}

	public static int BinaryMax(int[] arr, int index, int len) {
		if(len == 1) {
			System.out.println(arr[index]);
			return arr[index];
		}
		else {
			int first = BinaryMax(arr, index, len/2);
			int second = BinaryMax(arr, index+(len/2), (int)Math.ceil(len/2.0));
			if(first > second){
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
