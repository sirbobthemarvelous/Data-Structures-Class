package Exercise1;

public class Node {

	public int iData;              // data item (key)
	   public double dData;           // data item
	   public Node leftChild;         // this node's left child
	   public Node rightChild;        // this node's right child

	   //displayNode isnt part of the prompt
	   public double getDData()      // display ourself
	      {
	      return dData;
	      } 
	   public void setIData(int i) {
		   iData = i;
	   }
}
