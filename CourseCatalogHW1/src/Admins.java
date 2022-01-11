import java.util.ArrayList;
import java.util.Scanner;


public interface Admins {

	//Most methods could just be implemented with StoredLists but I didn't want Admin to be completely useless
	public void showStudentCourses(String firstName, String lastName, StoredLists Storage, Scanner scan);
	
	public String getUsername();
	public String getPassword();
	public String getFirstName();
	public String getLastName();
	public void setUsername(String name);
	public void setPassword(String pass);// well they won't be allowed to change it now
	public void setFirstName(String name);
	public void setLastName(String name);
}