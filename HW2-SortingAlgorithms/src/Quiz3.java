
public class Quiz3
   {
   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make new list
      //this code is for you to use to test you code
      //feel free to modify it. 

      theList.insertFirst(22, 2.99);      // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(55, 5.99);
      theList.insertFirst(110, 10.99); 
      theList.insertFirst(44, 4.99);
      theList.insertFirst(132, 12.99);
      //... add more elements if you want..

      //CALL and TEST YOUR METHODS HERE 
      theList.displayList();
//      theList.deleteFirst().displayLink();
//      theList.displayList();
//      System.out.print(theList.findMin());
//      theList.displaytheLastNODEiData();
//      theList.displayList();
//      theList.DeleteElementWithiData(66);
//      theList.displayList();
//      theList.removeDuplicates();
//      theList.displayList();
      theList.sortList();
      theList.displayList();
      
      }  // end main()
   }  // end class LinkListApp
////////////////////////////////////////////////////////////////