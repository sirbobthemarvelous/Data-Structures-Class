
public class LinkList
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public LinkList()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (first==null);
      }
// -------------------------------------------------------------
// insert at start of list
   public void insertFirst(int id, double dd)
      {                           
	   		Link far = new Link(id,dd);
	   		if(isEmpty()) {
	   			first = far;
	   		}
	   		else{
	   			far.setNext(first);
    	  		first = far;
	   		}
      }  
// -------------------------------------------------------------
   public Link deleteFirst()     
      {                           
	   		if(isEmpty()) {
	   			return null;
	   		}
	   		else { //double chekc this
	   			Link temp = first;
	   			first = first.getNext();
	   			temp.setNext(null);
	   			return temp;
	   		}
      }	  
// -------------------------------------------------------------
   public void displayList()
      {
	   Link upcoming = first;
	   while(upcoming != null) {
		   upcoming.displayLink();
		   upcoming = upcoming.getNext();
	   }
      //display all the elements in the lists

      }
	 
	// ------------------------------------------------------------- 
	 
// -------------------------------------------------------------
   public void displaytheLastNODEiData()
      {
      Link upcoming = first;
      while(upcoming.getNext() != null) {
    	  upcoming = upcoming.getNext();
      }
      System.out.println("The iData is: "+ upcoming.getIData());
      //display the last node's iData

      }
    
// ------------------------------------------------------------- 
    
	public int findMin(){
		Link upcoming = first;
		int smallest = first.getIData();
	    while(upcoming != null) {
	    	if(smallest > upcoming.getIData()) {
	    		smallest = upcoming.getIData();
	    	}
	    	upcoming = upcoming.getNext();
	    }
	    return smallest;

    //returns the minimum iData in the list

   } 
	 
// ------------------------------------------------------------- 


// ------------------------------------------------------------- 
    
   public void DeleteElementWithiData(int a){

    //this method will delete any node with iData == a. 
    //if there are many, the method will have to delete all of them.

	   	while(first.getIData()== a) {
	   		first = first.getNext();
	   	}
	   	Link previous = first;
   		Link upcoming = first.getNext();
   		
	    while(upcoming != null) {
	    	while(upcoming.getIData() == a) {
	    		Link temp = upcoming.getNext();
	    		previous.setNext(temp);
	    		upcoming = temp;
	    	}
	    	previous = upcoming;
	    	upcoming = upcoming.getNext();
	    }
   } 
    
// ------------------------------------------------------------- 
    	 
   public void removeDuplicates(){

	   Link compare = first;
	   Link upcoming = first.getNext();
	   Link previous = first;
	   while(compare != null) {
		   previous = compare;
		   upcoming = compare.getNext();
		   while(upcoming != null) {
			   while(upcoming.getIData() ==compare.getIData() 
					 && upcoming.getDData() ==compare.getDData()) {
		    		previous.setNext(upcoming.getNext());
		    		upcoming = upcoming.getNext();
			   }
			   previous = upcoming;
		    	upcoming = upcoming.getNext();
		   }
		   compare = compare.getNext();
	   }
	   
//	   ArrayList<Integer> dups = new ArrayList<Integer>();
//	   while(upcoming != null) {
//		   boolean found = false;
//		   do {
//			   for(int i = 0; i< dups.size();i++) {
//				   if(dups.get(i) == upcoming.getNext().getIData()) {
//					   Link temp = upcoming.getNext().getNext();
//					   upcoming.getNext().setNext(null);
//					   upcoming.setNext(temp);
//				   }
//			   }
//		   } while(found == true);
//	    upcoming = upcoming.getNext();
//	   }
    //this method will scan through the list and remove 
    //duplicates. (if the list is: 2->3->2->4->3->5->90 the method should
    //keep on copy of each duplicate, so the list become:
    //2->3->4->5-90
    //if there are no duplicates then the method does not need do anything

   } 
	 
// -------------------------------------------------------------

public void sortList(){
	//case where you don't need to sort
	if(isEmpty() || first.getNext()==null) return;
	//bubblesort, keep looking for differences until its fine

	Link after = first.getNext().getNext();
	Link position = first.getNext();
	Link previous = first;
	Link before = null;
	
	boolean found = false;
	do {
		System.out.println("begin loop");
		found = false;
		position = first.getNext();
		previous = first;
		
		if(first.getNext().getIData() < first.getIData()) {
			int firstInt = first.getIData(); // store data
			double firstDouble = first.getDData();
			first.setIData(first.getNext().getIData()); //swap data
			first.setDData(first.getNext().getDData());
			first.getNext().setIData(firstInt);
			first.getNext().setDData(firstDouble);
			
			found = true;
			System.out.println("swap first");
		}
		else if(first.getNext().getIData() == first.getIData()) {
			if(first.getNext().getDData() < first.getDData()) {
				int firstInt = first.getIData(); // store data
				double firstDouble = first.getDData();
				first.setIData(first.getNext().getIData()); //swap data
				first.setDData(first.getNext().getDData());
				first.getNext().setIData(firstInt);
				first.getNext().setDData(firstDouble);
//				first = first.getNext();
//				previous.setNext(first.getNext());
//				first.setNext(previous);
				found = true;
				System.out.println("swap first");
			}
		}
		previous = position;
		position = position.getNext();
		System.out.println("past first");
		
		while(position != null) {
			if(position.getIData() < previous.getIData()) {
				
				int priorInt = previous.getIData(); // store data
				double priorDouble = previous.getDData();
				previous.setIData(position.getIData()); //swap data
				previous.setDData(position.getDData());
				position.setIData(priorInt);
				position.setDData(priorDouble);
				System.out.println("swap misc");
	
		    	found = true;
			}
			else if(position.getIData() == previous.getIData()) {
				if(position.getDData() < previous.getDData()) {
					int priorInt = previous.getIData(); // store data
					double priorDouble = previous.getDData();
					previous.setIData(position.getIData()); //swap data
					previous.setDData(position.getDData());
					position.setIData(priorInt);
					position.setDData(priorDouble);
					
//					Link beyond = position.getNext().getNext();
//					position.getNext().setNext(position);
//					position.setNext(beyond);
//					Link beyond = position.getNext();
//					position.setNext(previous);
//					previous.setNext(beyond);
			    	found = true;
			    	System.out.println("swap misc");
				}
			}
			previous = position;
			position = position.getNext();
			System.out.println("inner loop");
		}
		System.out.println("end loop");
	}while(found == true);
	
	
//	Link upcoming = first;
//	
//		boolean found = false;
//		//the first swap method
//		if(upcoming.getIData() > upcoming.getNext().getIData()) {
//			first = first.getNext();
//			upcoming.setNext(upcoming.getNext().getNext().getNext());
//			upcoming.getNext().setNext(upcoming);
//		}
//		do {
//			found = false;
//			 while(upcoming.getNext().getNext() != null) {
//				 if(upcoming.getNext().getIData() > upcoming.getNext().getNext().getIData()) {
//						//we're swapping 2 and 3
//					 	Link Num4 = upcoming.getNext().getNext().getNext();
//					 	Link Num3 = upcoming.getNext().getNext();
//						Link Num2 = upcoming.getNext();
//						upcoming.setNext(Num3); // 1 to 3
//						upcoming.getNext().setNext(Num4); //2 to 4
//						upcoming.getNext().getNext().setNext(Num2);; //3 to 2
//						found = true;
//				}
//				 upcoming = upcoming.getNext();
//			 }
//		 } while(found == true);
	   
  
//write an algorithm that I will sort the list in-place
//do not use arrays. 

}

   }  // end class LinkList
////////////////////////////////////////////////////////////////