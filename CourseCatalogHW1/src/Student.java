import java.io.Serializable;
import java.util.ArrayList;

public class Student extends User implements Serializable, Students {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9180498697602037146L;;
	private ArrayList<Course> courseList;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	Student(){
		//empty constructor
	}
	
	//alternate Constructors
	public Student(String u, String p, String first, String last) {
		username = u;
		password = p;
		firstName = first;
		lastName = last;
		courseList = new ArrayList<Course>();
	}
	public Student(String u, String p, String first, String last, ArrayList<Course> courseList){
		//all the info
		username = u;
		password = p;
		firstName = first;
		lastName = last;
		this.courseList = courseList;
	}
	
	//getter class
	@Override
	public ArrayList<Course> getMyCourseList() {
		return courseList;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	//obligatory setter class
	public void setMyCourseList(ArrayList<Course> course) {
		courseList = course;
	}
	public void setUsername(String name) {
		username = name;
	}
	public void setPassword(String word) {
		password = word;
	}
	public void setFirstName(String name) {
		firstName = name;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	
	//Some more usable classes to edit the course list
	//add a course to the arraylist
	public void addToCourseList(Course c) {
		courseList.add(c);
	}
	//adding a course to a specific index
	public void addToCourseList(Course c, int index) {
		courseList.add(index, c);
	}

	//delete course by Course
	public void deleteCourse(Course c) {
		for(Course e: courseList) {
			if(e == c) {
				courseList.remove(e);
			}
		}
	}
	//delete course by index
	public void deleteCourse(int c) {
		courseList.remove(c);
	}

}
