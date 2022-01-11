import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class StoredLists implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9180498697602037146L;
	
	//We will serialize the list of courses and list of students in this object
	private boolean adminActivated;
	private ArrayList<Student> studentList;
	private ArrayList<Course> courseList;
	//maybe we could do something about passwords being transient or something
	
	StoredLists(){
		/*Empty Constructor*/
		adminActivated = false;
		studentList = new ArrayList<Student>();
		courseList = new ArrayList<Course>();
	}
	//constructor with relevant info
	public StoredLists(boolean active, ArrayList<Student> list, ArrayList<Course> courses){
		adminActivated= active;
		studentList = list;
		courseList = courses;
	}
	//getter classes
	public boolean getAdminActivated() {
		return adminActivated;
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	//setter methods
	public void setStudentList(ArrayList<Student> students) {
		studentList = students;
	}
	public void setCourseList(ArrayList<Course> courses) {
		courseList = courses;
	}
	public void activateAdmin() {
		adminActivated = true;
	}
	//Various methods to change the courselist or studentlist for the GUI
	//Viewing the course list
	public void viewAllCourses() {
		for(Course c: courseList) {
			c.viewPrint();
		}
	}
	//viewing the courses that are available
	public void viewAvailableCourses() {
		for(Course c: courseList) {
			if(c.getMaxStudents()>c.getRegistered()) {
				c.viewPrint();
			}
		}
	}
	//viewing the courses that are FULL
	public void viewAllFullCourses() {
		for(Course c: courseList) {
			if(c.getMaxStudents()==c.getRegistered()) {
				c.viewPrint();
			}
		}
	}
	//getting all the courses so you can write to a file
	public String getAllFullCourses() {
		String writeYo = "";
		for(Course c: courseList) {
			if(c.getMaxStudents()==c.getRegistered()) {
				writeYo += c.getPrint();
			}
		}
		return writeYo;
	}
	//course editing of various kinds
	//add a course to the course list
	public void addCourse(Course c) {
		courseList.add(c);
	}
	//delete a specific course on the course list
	public void deleteCourse(Course c) {
		courseList.remove(c);
	}
	//Sorting the courses by Number of registered students
	public void sortCourses() {
		Collections.sort(courseList);
		System.out.println("Courses have been Sorted");
	}
	
	//registering a new student
	public void addStudent(Student s) {
		studentList.add(s);
	}

}
