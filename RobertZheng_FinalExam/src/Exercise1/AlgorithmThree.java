package Exercise1;

import java.io.IOException;
import java.util.ArrayList;

public class AlgorithmThree {
//Create a BST
	public static void main(String[] args) throws IOException
    {
	int [] set = {5,2,6,3,15,633,1637,582,1,25,4,325,32,4,2,16};
    Tree theTree = new Tree();
    
	    for(int i: set) { //insert the unsorted elements into a BST
			System.out.println(i);
			theTree.insert(i, 1.0);
		}
	    
    ArrayList<Integer> arrr = new ArrayList<Integer>();
    theTree.inOrder(theTree.getRoot(), arrr); //inorder traversal
    
    System.out.println("Here's the numbers sorted: ");
	    for(int i: arrr) { //print out the sorted elements 
			System.out.println(i);
		}

    }
}
