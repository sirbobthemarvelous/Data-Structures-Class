package Exercise4;

public class MergeLinkedLists {
	public static void main(String[] args)
    {
    LinkList theList = new LinkList();  
    theList.insertFirst(11, 99, "Micheal");
    theList.insertFirst(20, 97, "Carl");
    theList.insertFirst(15, 95, "Robert");
    theList.insertFirst(7, 82, "Rose");
    theList.insertFirst(10, 77, "Buford"); 

    LinkList nextList = new LinkList();
    nextList.insertFirst(2, 98, "Michelle");
    nextList.insertFirst(8, 96, "Chloe");
    nextList.insertFirst(6, 87, "Amy");
    nextList.insertFirst(3, 85, "Andrew");
    nextList.insertFirst(12, 75, "Beth");
    
    
    theList.displayList();
    nextList.displayList();
    LinkList newList = merge(theList,nextList);
    System.out.println("here comes the fusion");
    newList.displayList();
    
    }  // end main()
	
	public static LinkList merge(LinkList first, LinkList second) {
		LinkList result = new LinkList();
		result.insertFirst(-1, -1, "NA");
		Link position = first.getFirst();
		Link position2 = second.getFirst();
		Link position3 = result.getFirst();
		
		if(position.grade < position2.grade) {
			position3.setNext(position);
			position = position.getNext();
			position3 = position3.getNext();
		}
		else {
			position3.setNext(position2);
			position2 = position2.getNext();
			position3 = position3.getNext();
		}
		result.setFirst(position3);
		//two for loops 
		while(position != null && position2 != null) {
			//compare which is lower
			if(position.grade < position2.grade) {
				position3.setNext(position);
				
				position = position.getNext();
				position3 = position3.getNext();
			}
			else {
				position3.setNext(position2);
				position2 = position2.getNext();
				position3 = position3.getNext();
			}
			//in the event that you reach the end of one array
			while(position != null && position2 == null) {
				position3.setNext(position);
				position = position.getNext();
				position3 = position3.getNext();
			}
			while(position == null && position2 != null) {
				position3.setNext(position2);
				position2 = position2.getNext();
				position3 = position3.getNext();
			}
			
		}
		
		
		return result;
	}

}
