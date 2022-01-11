import java.util.ArrayList;

public interface Students {
//you don't need to put variables like username or password here
	//just method signatures
	public ArrayList<Course> getMyCourseList();
	public void addToCourseList(Course c);
	public void addToCourseList(Course c, int index);
	public void deleteCourse(Course c);
	public void deleteCourse(int c);
}



