
public class R3Question_2 {

	public int maxInt(int[] arr, int maximum, int count) {
		int max;
		if(count == 0) {
			if(arr[0]>maximum) {
				return arr[0];
			}
			return maximum;
		}
		if(arr[count]> maximum) {
			max = arr[arr.length];
			count += -1;
			maxInt(arr, max, count);
		}
		else {
			count += -1;
			maxInt(arr, maximum, count);
		}
		return 0;
	}
}
