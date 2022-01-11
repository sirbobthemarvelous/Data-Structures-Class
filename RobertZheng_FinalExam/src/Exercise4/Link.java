package Exercise4;
////////////////////////////////////////////////////////////////
public class Link
   {
   public int ID;              // data item
   public int grade;   // data item
   public String name;		//data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, int g, String n) // constructor
      {
      ID = id;                 // initialize data
      name = n;
      grade = g;                 // ('next' is automatically
      }                           //  set to null)
// -------------------------------------------------------------
   public void setNext(Link after) {
	   next = after;
   }
   public Link getNext() {
	   return next;
   }
   public void setID(int i) {
	   ID = i;
   }
   public int getID() {
	   return ID;
   }
   public void setGrade(int g) {
	   grade = g;
   }
   public int getGrade() {
	   return grade;
   }
   public void setName(String n) {
	   name = n;
   }
   public String getName() {
	   return name;
   }
   public void displayLink()      // display ourself
      {
      System.out.println("ID: " + ID + ", Grade: " + grade + ",Name: "+ name+ "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////