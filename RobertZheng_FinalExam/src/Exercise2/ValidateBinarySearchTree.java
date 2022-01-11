package Exercise2;

import java.io.IOException;
import java.util.ArrayList;

public class ValidateBinarySearchTree {
	public static void main(String[] args) throws IOException
    {
		Tree theTree = new Tree();
		theTree.insert(15, 95, "Robert");
		theTree.insert(8, 96, "Chloe");
	    theTree.insert(20, 97, "Carl");
	    theTree.insert(2, 98, "Michelle");
	    theTree.insert(11, 99, "Micheal");
	    theTree.insert(6, 87, "Amy");
	    theTree.insert(3, 85, "Andrew");
	    theTree.insert(7, 82, "Rose");
	    theTree.insert(10, 77, "Buford"); 
	    theTree.insert(12, 75, "Beth");
	    System.out.println(isBST(theTree)); //should return true
        theTree.getRoot().setID(100); //no longer a BST
        System.out.println(isBST(theTree)); //should return false
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
