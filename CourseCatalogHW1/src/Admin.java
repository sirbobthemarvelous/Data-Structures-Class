import java.util.Scanner;

public class Admin extends User implements Admins {
	private String username = "Admin";
	private String password = "Admin001";

	Admin(){
		//empty constructor is all that's needed since the username and password won't change
	}
	//Print out all the courses a Student is registered in
	@Override
	public void showStudentCourses(String firstName, String lastName, StoredLists Storage,Scanner scan) {
		for(Student i:Storage.getStudentList()) {
			if(i.getFirstName().equals(firstName) && i.getLastName().equals(lastName)) {
				for(Course c: Storage.getCourseList()) {
					System.out.println(c.getPrint());
					workflow.adminMenu(Storage,scan);
				}
			}
		}
			System.out.println("Error student not found");
			workflow.adminMenu(Storage,scan);
	
	}
	//Getter methods
		public String getUsername() {
			return super.getUsername();
		}
		public String getPassword() {
			return super.getPassword();
		}
		//Setter methods
		public void setUsername(String name) {
			//override the method so it does nothing
			username = "Admin";
		}
		public void setPassword(String word) {
			//it just isn't meant to change
			password = "Admin001";
		}
}
//the constructor for Admin sounds like a good place as any to add overloading