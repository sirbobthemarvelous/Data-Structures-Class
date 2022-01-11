package Exercise2;

public class Node {

		public int ID;              // data item (key)
	   public int grade;           // grade
	   public String name; 				//name
	   public Node leftChild;         // this node's left child
	   public Node rightChild;        // this node's right child

	   //displayNode isnt part of the prompt
	   public int getID()      
	      {
	      return ID;
	      } 
	   public int getGrade()      
	      {
	      return grade;
	      } 
	   public String getName()      
	      {
	      return name;
	      } 
	   public void setID(int i) {
		   ID = i;
	   }
	   public void setGrade(int g) {
		   grade = g;
	   }
	   public void setName(String n) {
		   name = n;
	   }
}
