
public class R3Question_3 {

	public int evenNegSums(int[] arr, int count) {

		if(count == 0) {
			if(arr[count]%2==0 || arr[count]<0) {
				return arr[0];
			}
			return 0;
		}
		if(arr[count]%2==0 || arr[count]<0) {
			return arr[count]+ evenNegSums(arr,count-1);
		}
		else {
			return evenNegSums(arr,count-1);
		}
	}
}
