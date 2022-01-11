
public class Exercise2_ThirdWord {

	public static void main(String[] args) {
		System.out.println(Math.ceil(5/2.0));
		String str = "I plan on using the split() method to split the string";  
		String ex = "Other entries include a historic district in Charlottesville Virginia cut-flower greenhouse complex";
		System.out.println(Thirds(str)); 
		System.out.println(Thirds(ex));
		
	}
	

	public static String Thirds(String pasta) { //runtime of O(n)

		String[] filled = null;
		filled = pasta.split(" "); //split the string into an array of string words
		//split method has a runtime of O(n)
		String[] end = new String[(int)Math.ceil(filled.length/3.0)];
		int count = 0;
		//you can directly find the amount of words by the length of filled
		
		String smallest = filled[0]; 
		
		for (int i = 0; i< filled.length; i++){  //runtime of O(n)
			if(filled[i].length() < smallest.length()) { //checking for smallest
				smallest = filled[i];
			}
			if((i+1)%3 ==0 || i == filled.length-1) {
				end[count]= smallest;
				count++;
				if(i < filled.length-1) {
					smallest = filled[i+1]; 
					//start checking the newest of the set of 3 words
				}
			}
		}  
		
		String endProduct = String.join(" ", end);//runtime of O(n)
		return endProduct;
	}
}
