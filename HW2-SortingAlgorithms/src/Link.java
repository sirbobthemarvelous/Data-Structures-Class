////////////////////////////////////////////////////////////////
public class Link
   {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, double dd) // constructor
      {
      iData = id;                 // initialize data
      dData = dd;                 // ('next' is automatically
      }                           //  set to null)
// -------------------------------------------------------------
   public void setNext(Link after) {
	   next = after;
   }
   public Link getNext() {
	   return next;
   }
   public void setIData(int i) {
	   iData = i;
   }
   public int getIData() {
	   return iData;
   }
   public void setDData(double d) {
	   dData = d;
   }
   public double getDData() {
	   return dData;
   }
   public void displayLink()      // display ourself
      {
      System.out.println("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link
////////////////////////////////////////////////////////////////