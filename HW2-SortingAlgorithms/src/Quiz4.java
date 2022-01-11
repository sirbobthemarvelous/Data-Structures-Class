import java.io.*;
import java.util.*; 

public class Quiz4 {

	   public static void main(String[] args) throws IOException
	      {
	      Tree theTree = new Tree();

	      theTree.insert(15, 1.5);
	      theTree.insert(8, 1.6);
	      theTree.insert(20, 1.7);
	      theTree.insert(2, 1.8);
	      theTree.insert(11, 1.9);
	      theTree.insert(6, 2.7);
	      theTree.insert(3, 2.5);
	      theTree.insert(7, 2.2);
	      theTree.insert(10, 3.7); //test 1
	      theTree.insert(12, 3.5);
	      theTree.insert(14, 3.7);
	      theTree.insert(27, 4.5);
	      theTree.insert(22, 4.2);
	      theTree.insert(30, 4.7);

	         System.out.print(theTree.find(10).getDData());
	         //should return 3.7
	         
		     theTree.insert(33, 5.7);
	         theTree.displayTree();
	         theTree.delete(8);
	         theTree.displayTree();
	         System.out.print(isBST(theTree));
	         theTree.getRoot().setIData(100); //no longer a BST
	         System.out.print(isBST(theTree));
	      }

	private static boolean isBST(Tree maybe) {
		// inorder traversal create array
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		maybe.inOrder(maybe.getRoot(),arr);
		
		//go through array and check its in order.
		for(int i=0; i<arr.size()-1; i++) {
			if(arr.get(i)>arr.get(i+1)) {
				return false;
			}
		}
		return true;
	}
}
