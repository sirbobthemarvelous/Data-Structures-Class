package Exercise2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchTreeMenu {
	public static void main(String[] args) throws IOException
    {
		Tree theTree = new Tree();
		Scanner scan = new Scanner(System.in);
		
		while(true)
        {
			System.out.println("Enter '1' or '2' etc, for the corresponding request: \n"
					+ "1. Create a BST ordered by students' IDs \n"
					+ "2. Insert a new student \n"
					+ "3. Delete a student \n"
					+ "4. Search for student by ID and display their grade and name \n"
					+ "5. Display students' IDs sorted \n"
					+ "6. Display students' Grades sorted \n"
					+ "7. Display ALL student grades above a certain value entered by user \n"
					+ "8. Exit ");
			String answer = scan.nextLine();
			if(answer.equals("1")) { //create BST
				theTree = optionOne(theTree);
			}
			else if(answer.equals("2")) { //insert student
				theTree = optionTwo(theTree);
			}
			else if(answer.equals("3")) {// delete student
				theTree = optionThree(theTree);
			}
			else if(answer.equals("4")) { //search for student
				optionFour(theTree);
			}
			else if(answer.equals("5")) { //display IDs sorted
				optionFive(theTree);
			}
			else if(answer.equals("6")) { //display grades sorted
				optionSix(theTree);
			}
			else if(answer.equals("7")) { //display grades above a value
				optionSeven(theTree);
			}
			else if(answer.equals("8")) { //exit
				break;
			}
			else {
				System.out.print("Error, please type a number from 1-8");
			}
        }  // end while
    }
	
	public static Tree optionOne(Tree theTree) {
		Scanner scan1 = new Scanner(System.in);

		while(true) {
			System.out.println("Enter '1' to automatically create a BST of 10 students  \n"
					+ "Enter '2' to manually input 10 students' ID, name and grade \n"
					+ "Enter '3' to exit");
			String choice = scan1.nextLine();
			if(choice.equals("2")) { //create BST manually
				for(int i=0;i<10;i++) {
					theTree = optionTwo(theTree);
				}
				theTree.displayTree();
				break;
			}
			else if(choice.equals("1")) { //automatically
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
			    theTree.displayTree();
			    break;
			}
			else if(choice.equals("3")) {
				break;
			}
			else{
				System.out.print("Error, please type either 1 or 2 or 3");
			}
		}
		
	    
	    return theTree;
	}
	public static Tree optionTwo(Tree theTree) {
		Scanner scan2 = new Scanner(System.in);
		
		System.out.println("Enter student ID:");
		int IDss = Integer.parseInt(scan2.nextLine());
		System.out.println("Enter student grade:");
		int gradess = Integer.parseInt(scan2.nextLine());
		System.out.println("Enter student name:");
		String namess = scan2.nextLine();
		
		theTree.insert(IDss, gradess, namess);
		theTree.displayTree();
		return theTree;
	}
	
	public static Tree optionThree(Tree theTree) {
		Scanner scan3 = new Scanner(System.in);
		
		System.out.println("Enter ID of student to be deleted:");
		int ID = Integer.parseInt(scan3.nextLine());
		theTree.delete(ID);
		theTree.displayTree();
		return theTree;
	}
	public static void optionFour(Tree theTree) {
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Enter ID of student to be displayed:");
		int ID = Integer.parseInt(scan4.nextLine());
		Node student = theTree.find(ID);
		System.out.println("Student's grade is: " + student.getGrade() +
		"\n Student's name is: "+ student.getName());
	}
	
	public static void optionFive(Tree theTree) {
		ArrayList<Integer> arrr = new ArrayList<Integer>();
	    theTree.inOrder(theTree.getRoot(), arrr); //inorder traversal
	    
	    System.out.println("Here's the student IDs sorted: ");
	    for(int i: arrr) { //print out the sorted elements 
			System.out.println(i);
		}
	    
	}
	
	public static void optionSix(Tree theTree) {
		ArrayList<Integer> arrr = new ArrayList<Integer>();
		theTree.inOrderGrades(theTree.getRoot(), arrr); //get the grades
		
		int[] arr = arrr.stream().mapToInt(i -> i).toArray(); //convert to array
		for (int x : arr)
            System.out.print(x + " ");
	    int[] result = BinarySort(arr,0,arr.length); //sort grades
	    
	    System.out.println("Here's the student Grades sorted: ");
	    for(int i: result) { //print out the sorted elements 
			System.out.println(i);
		}
		
	}
	public static int[] BinarySort(int[] arr, int index, int len) {
		if(len == 1) { //base case you find each individual element
			int [] piece = {arr[index]};
			return piece;
		}
		else {
			//calling the binary recursion while multiplying it by the number of elements it contains
			int[] first = BinarySort(arr, index, len/2);
			int[] second = BinarySort(arr, index+(len/2), (int)Math.ceil(len/2.0));
			//then divide the total number of elements in the end
			return merge(first,second);
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
	
	public static void optionSeven(Tree theTree) {
		Scanner scan7 = new Scanner(System.in);
		System.out.println("Enter grade threshold:");
		int gradeThreshold = Integer.parseInt(scan7.nextLine());
		
	    ArrayList<Integer> arrr = new ArrayList<Integer>();
		theTree.inOrderGrades(theTree.getRoot(), arrr); //get all the grades
		
		int[] arr = arrr.stream().mapToInt(i -> i).toArray(); //convert to array
	    
	    System.out.println("Here's the student Grades above the threshold: ");
	    for(int i: arr) { //print out the elements 
	    	if(i> gradeThreshold ) {//that are above the threshold
	    		System.out.println(i);
	    	}
		}
	}

}
