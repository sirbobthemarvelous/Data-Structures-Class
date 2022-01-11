import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable, Comparable<Course>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9180498697602037146L;
	private String courseName;
	private int ID;
	private int maxStudents;
	private int registered;
	private ArrayList<String> nameRoster;
	private String instructor;
	private int sectionNum;
	private String location;

	Course(){
		/*Empty Constructor*/
	}
	//constructor with relevant info
	public Course(String courseName, int ID, int maxStudents, int registered, ArrayList<String> nameRoster, String instructor, int sectionNum, String location){
		this.courseName = courseName;
		this.ID = ID;
		this.maxStudents = maxStudents;
		this.registered = registered;
		this.nameRoster = nameRoster;
		this.instructor = instructor;
		this.sectionNum = sectionNum;
		this.location = location;
	}
	//An alternate constructor for ease of reading csv
	public Course(String courseName, String ID, String maxStudents, String registered, String nameRoster, String instructor, String sectionNum, String location) {
		this.courseName = courseName;
		this.ID = Integer.parseInt(ID);
		this.maxStudents = Integer.parseInt(maxStudents);
		this.registered = Integer.parseInt(registered);
		// This is for Sake of Convenience, If I make a GUI I'll implement arraylist for this
		this.nameRoster = new ArrayList<String>();
		this.instructor = instructor;
		this.sectionNum = Integer.parseInt(sectionNum);
		this.location = location;
	}
	//getter Classes
	public String getCourseName() {
		return courseName;
	}
	public int getID() {
		return ID;
	}
	public int getMaxStudents() {
		return maxStudents;
	}
	public int getRegistered() {
		return registered;
	}
	public ArrayList<String> getNameRoster() {
		return nameRoster;
	}
	public String getInstructor() {
		return instructor;
	}
	public int getSectionNum() {
		return sectionNum;
	}
	public String getLocation() {
		return location;
	}
	//setter classes
	public void setCourseName(String name) {
		courseName = name;
	}
	public void setID(int id) {
		ID = id;
	}
	public void setMaxStudents(int max) {
		maxStudents = max;
	}
	public void setRegistered(int registered) {
		this.registered = registered;
	}
	public void setNameRoster(ArrayList<String> roster) {
		nameRoster = roster;
	}
	//adds a name to the name Roster
	public void addToRoster(String newName) {
		nameRoster.add(newName);
	}
	//removes a name from the roster
	public void removeFromRoster(String oldName) {
		nameRoster.remove(oldName);
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public void setSectionNum(int section) {
		sectionNum = section;
	}
	public void setLocation(String locale) {
		location = locale;
	}
	//print method for viewing courses
	public void viewPrint() {
	System.out.println("Course Name: " + courseName +"\n" 
	+"Course ID: "+ ID+"\n"
	+"Max Student Capacity: "+ maxStudents+"\n"
	+"Students Registered: "+ registered+"\n"
	+"Section Number: "+ sectionNum+"\n");
	}
	//print method for displaying full info for courses
	public void fullViewPrint() {
	System.out.println("Course Name: " + courseName +"\n" 
				+"Course ID: "+ ID+"\n"
				+"Max Student Capacity: "+ maxStudents+"\n"
				+"Students Registered: "+ registered+"\n"
				+"Name Roster Delimited by Commas: "+ nameRoster+"\n"
				+"Instructor: "+ instructor +"\n"
				+"Section Number: "+ sectionNum+"\n"
				+"Course Location: "+ location+"\n");
	}
	//method to return the courses in string form rather than just displaying it
	public String getPrint() {
		return "Course Name: " + courseName +"\n" 
		+"Course ID: "+ ID+"\n"
		+"Max Student Capacity: "+ maxStudents+"\n"
		+"Students Registered: "+ registered+"\n";
	}
	//override the compareTo method to make the sort method work
		@Override 
		public int compareTo(Course comparecour)
	    {
	        int comparestus
	            = ((Course)comparecour).getRegistered();
	        
	        return this.registered - comparestus;
	    }
}