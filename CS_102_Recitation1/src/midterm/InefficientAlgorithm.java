package midterm;

public class InefficientAlgorithm {
	public static void main(String[] args) {
		int [] set = {5,2,6,3};
		addSizeToTheSecond(set);
		
		for(int i: set) { //print out the elements 
			System.out.println(i);
		}
		
	}

	public static void addSizeToTheSecond(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length;j++) {
				for(int k = 0; k<arr.length;k++) {
					arr[k] = arr[k]+1;
				}
			}
		}
				
	}
}
