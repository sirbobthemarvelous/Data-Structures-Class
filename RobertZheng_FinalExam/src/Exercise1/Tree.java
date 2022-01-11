package Exercise1;
import java.util.ArrayList;
import java.util.Stack;

public class Tree {

	   private Node root;             // first node of tree

	// -------------------------------------------------------------
	   public Tree()                  // constructor
	      { root = null; }            // no nodes in tree yet
	// -------------------------------------------------------------
	   public Node find(int key)      // find node with a specific key
	      {                           // (assumes non-empty tree)
	      Node current = root;               // start at root
	      while(current.iData != key)        // while no match,
	         {
	         if(key < current.iData)         // go left?
	            current = current.leftChild;
	         else                            // or go right?
	            current = current.rightChild;
	         if(current == null)             // if no child is there,
	            return null;                 // either it's not a BST or not here
	         }
	      return current;                    // found it
	      }  // end find()
	// -------------------------------------------------------------
	   public void insert(int id, double dd)
	      {
	      Node newNode = new Node();    // make new node
	      newNode.iData = id;           // add in the data
	      newNode.dData = dd;
	      if(root==null)                // If the entire tree is empty
	         root = newNode;			//put it in the root
	      else                          // otherwise
	         {
	         Node current = root;       // start at root
	         Node parent;				// keep this like an iterator
	         
	         while(true)                // (loop until you find the place to insert the node)
	            {
	            parent = current;		//catching up with any changes current had in the last loop
	            if(id < current.iData)  // go left?
	               {
	               current = current.leftChild;
	               if(current == null)  // if end of the line,
	                  {                 // insert on left
	                  parent.leftChild = newNode;
	                  return;
	                  }
	               }  // end if go left
	            else                    // or go right?
	               {
	               current = current.rightChild;
	               if(current == null)  // if end of the line
	                  {                 // insert on right
	                  parent.rightChild = newNode;
	                  return;
	                  }
	               }  // end else go right
	            }  // end while loop
	         }  // end else not root
	      }  // end insert()
	// -------------------------------------------------------------
	   public boolean delete(int key) // delete node with a chosen key
	      {                           // (assumes non-empty list)
	      Node current = root;
	      Node parent = root;
	        
		  boolean isLeftChild = true;		//keep track of if it is a left child

	      while(current.iData != key)        // traverse the tree until you find the node
	         {
	         parent = current;				//parent catching up with the last loop changes
	         if(key < current.iData)         // go left?
	            {
	            isLeftChild = true;
	            current = current.leftChild;
	            }
	         else                            // or go right?
	            {
	            isLeftChild = false;
	            current = current.rightChild;
	            }
	         if(current == null)             // end of the line,
	            return false;                // didn't find it
	         }  // end while
	      
	      // after finding the node to delete

	      // if no children, simply delete it
	      if(current.leftChild==null &&
	                                   current.rightChild==null)
	         {
	         if(current == root)             // if root,
	            root = null;                 // tree is empty
	         else if(isLeftChild)
	            parent.leftChild = null;     // disconnect
	         else                            // from parent
	            parent.rightChild = null;
	         }

	      // if only no right child, replace with left subtree
	      else if(current.rightChild==null)
	         if(current == root)
	            root = current.leftChild;
	         else if(isLeftChild)
	            parent.leftChild = current.leftChild;
	         else
	            parent.rightChild = current.leftChild;

	      // if only no left child, replace with right subtree
	      else if(current.leftChild==null)
	         if(current == root)
	            root = current.rightChild;
	         else if(isLeftChild)
	            parent.leftChild = current.rightChild;
	         else
	            parent.rightChild = current.rightChild;

	      else  // two children, so replace with inorder successor
	         {
	         // get successor of node to delete (current)
	         Node successor = getSuccessor(current);

	         // replace the deleted node with the successor
	         if(current == root) //if you're ultimately replacing the root
	            root = successor;
	         else if(isLeftChild) 
	            parent.leftChild = successor;
	         else
	            parent.rightChild = successor;

	         // connect successor to current's left child
	         successor.leftChild = current.leftChild;
	         }  // end else two children
	      // (successor cannot have a left child because they are the leftmost right child
	      return true;                                // success
	      }  // end delete()
	// -------------------------------------------------------------
	   // returns node with next-highest value after delNode
	   // goes to right child, then right child's left descendents
	   private Node getSuccessor(Node delNode)
	      {
	      Node successorParent = delNode;
	      Node successor = delNode;
	      Node current = delNode.rightChild;   // go to right child
	      while(current != null)               // until no more 
	         {                                 // left children,
	         successorParent = successor;
	         successor = current;
	         current = current.leftChild;      // go to left child until there are no more left children
	         }
	                                           // if successor is not
	      if(successor != delNode.rightChild)  // the right child itself,
	         {                                 // make connections
	         successorParent.leftChild = successor.rightChild; //pushing the successors kid to where they used to be
	         successor.rightChild = delNode.rightChild; 
	         }
	      return successor;
	      }


	// -------------------------------------------------------------
	   public void inOrder(Node localRoot, ArrayList<Integer> arr)
	      {
	      if(localRoot != null)
	         {
	         inOrder(localRoot.leftChild, arr);
	         arr.add(localRoot.iData);
	         inOrder(localRoot.rightChild, arr);
	         }
	      }
	// -------------------------------------------------------------
	   public Node getRoot()
	      {
	      return root;
	      }
	// -------------------------------------------------------------
	   public void displayTree()
	      {
	      Stack globalStack = new Stack();
	      globalStack.push(root);
	      int nBlanks = 32;
	      boolean isRowEmpty = false;
	      System.out.println(
	      "......................................................");
	      while(isRowEmpty==false)
	         {
	         Stack localStack = new Stack();
	         isRowEmpty = true;

	         for(int j=0; j<nBlanks; j++)
	            System.out.print(' ');

	         while(globalStack.isEmpty()==false)
	            {
	            Node temp = (Node)globalStack.pop();
	            if(temp != null)
	               {
	               System.out.print(temp.iData);
	               localStack.push(temp.leftChild);
	               localStack.push(temp.rightChild);

	               if(temp.leftChild != null ||
	                                   temp.rightChild != null)
	                  isRowEmpty = false;
	               }
	            else
	               {
	               System.out.print("--");
	               localStack.push(null);
	               localStack.push(null);
	               }
	            for(int j=0; j<nBlanks*2-2; j++)
	               System.out.print(' ');
	            }  // end while globalStack not empty
	         System.out.println();
	         nBlanks /= 2;
	         while(localStack.isEmpty()==false)
	            globalStack.push( localStack.pop() );
	         }  // end while isRowEmpty is false
	      System.out.println(
	      "......................................................");
	      }  // end displayTree()
}
