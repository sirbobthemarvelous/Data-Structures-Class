package Exercise4;

public class SortLinkedLists {

	public static void main(String[] args)
    {
    LinkList theList = new LinkList();  // make new list

    theList.insertFirst(15, 95, "Robert");
    theList.insertFirst(8, 96, "Chloe");
    theList.insertFirst(20, 97, "Carl");
    theList.insertFirst(2, 98, "Michelle");
    theList.insertFirst(11, 99, "Micheal");
    theList.insertFirst(6, 87, "Amy");
    theList.insertFirst(3, 85, "Andrew");
    theList.insertFirst(7, 82, "Rose");
    theList.insertFirst(10, 77, "Buford"); 
    theList.insertFirst(12, 75, "Beth");
    
    theList.displayList();
    theList.sortList(); //sorting the students by grade
    theList.displayList();
    
    }  
}
