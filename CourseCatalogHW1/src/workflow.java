import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class workflow {

	public static void main(String[] args) {
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		//Preparing to create a StoredLists object when serializing
		StoredLists Storage = new StoredLists();
		
		Scanner scan = new Scanner(System.in);
		 //passing around the Scanner class like the Storage class?
		
		//my program is a lot of chaining methods

		//first time logging in? does the student methods exist?
		System.out.println(Paths.get("").toAbsolutePath());
		
		File file  = new File("Stored.ser");
		if (file.exists()) {
			//so you already have the course data and student data
			//SO DESERIALIZE please
			deserialize(Storage);
			
			//then we go on to ask student or admin?
			studentVadmin(Storage, scan);
				//username and password within that too
			
			// after that jump to method Main Menu
		}
		else {
			//get ready to store an arraylist of courses
			String line = null;  
			String splitBy = ",";  
		
			try {
				FileReader fileReader = new FileReader("C://Users//robzh//Documents//CS_102_DataStructures//CourseCatalogHW1//MyUniversityCourses (4).csv");
				BufferedReader br = new BufferedReader(fileReader);  
			
					String labels = br.readLine(); //let the labels be read first
					labels = "";
				
			while ((line = br.readLine()) != null)  //returns a Boolean value  
				{  
				String[] info  = line.split(splitBy);    // use comma as separator 
				courses.add(new Course(info[0],info[1].replace("CSCI-GA.", "").replace("CSCI-UA.", ""),info[2],info[3],info[4],info[5],info[6],info[7]));  
				}
			br.close();
			}
			catch(FileNotFoundException ex){
				System.out.println( "Unable to open file");
				//the printStackTrace method will print out an error output stream ("What went wrong?" report);
				
				ex.printStackTrace();
			}
			catch (IOException ex) {
				System.out.println( "Error reading file");
				ex.printStackTrace();
			}
			
			//add the Welcome to creating/being a new Admin stuff
			if(Storage.getAdminActivated() != true) {
				System.out.println("Welcome new Admin. Your Username and Password are 'Admin' and 'Admin001' respectively");
			}
			Storage.activateAdmin();
			System.out.println("admin activated");
			Storage.setStudentList(students);
			System.out.println("student list set");
			Storage.setCourseList(courses);
			System.out.println("course list set");
			serialize(Storage);
			deserialize(Storage);
			System.out.println("As a new admin, please remember to register new students before using the Student Login");
			//then we go on to ask student or admin?
			studentVadmin(Storage, scan);
		}
		//Once you're done using the menus, the data is stored
		serialize(Storage);
	}
		
	
	//asks Whether you're a student or Admin
	public static void studentVadmin(StoredLists Storage, Scanner scan) {
		System.out.println("Enter 's' for student, 'a' for admin, enter 'exit' at any time to return to previous menu: ");
		String answer = scan.nextLine();
		if(answer.equals("s")) {
			studentLogin(Storage, scan);
		}
		else if(answer.equals("a")) {
			//implementing the admin login method and then it goes to the admin menu method
			System.out.println("Enter username:");
			String username = scan.nextLine();
			System.out.println("Enter password:");
			String password = scan.nextLine();
			if(username.equals("Admin") && password.equals("Admin001")) {
				adminMenu(Storage,scan);
			}
			else {
				System.out.println("incorrect Username or Password");
				studentVadmin(Storage, scan);
			}
		}
		else if(answer.equals("exit")) {
			serialize(Storage);
		}
		else {
			System.out.println("Please enter either lowercase s or a");
			studentVadmin(Storage, scan);
		}
		studentVadmin(Storage, scan);
	}
	
	//The Student Login Menu
	public static void studentLogin(StoredLists Storage, Scanner scan) {
		//implement student login method then go to student menu method
		System.out.println("Enter username:");
		String username = scan.nextLine();
		System.out.println("Enter password:");
		String password = scan.nextLine();
		
		//if you want to exit this menu
		if(password.equals("exit")) {
			studentVadmin(Storage,scan);
			return;
		}
		//do a loop to check that the usernmae and password matches up with a student
		for(Student i:Storage.getStudentList()) {
			if(i.getUsername().equals(username) && i.getPassword().equals(password)) {
				studentMenu(Storage, i, scan);
			}
		}
			System.out.println("incorrect Username or Password");
			studentLogin(Storage, scan);
	
	}
	//main menu method for students
	public static void studentMenu(StoredLists Storage, Student kid, Scanner scan) {
		System.out.println("Enter '1' to View all courses \n "
				+ "'2' to View all courses that aren't full \n "
				+ "'3' to Register on a course \n"
				+ "'4' to Withdraw from a course \n"
				+ "'5' to View all courses that the current student is registered in \n"
				+ "or '6' to  Exit");
		String answer = scan.nextLine();
		if(answer.equals("1")) {
			//method to view all the courses
			Storage.viewAllCourses();
		}
		else if(answer.equals("2")) {
			//method to view all the Available courses
			Storage.viewAvailableCourses();
		}
		else if(answer.equals("3")) {
			//method to Register to a Course
			registerTheKid(Storage, kid,scan);
		}
		else if(answer.equals("4")) {
			//method to Withdraw from a course
			withdrawTheCourse(Storage,kid,scan);
		}
		else if(answer.equals("5")) {
			//method to view all the courses The student is registered in
			for(Course c:kid.getMyCourseList()) {
				c.fullViewPrint();
			}
		}
		else if(answer.equals("6")) {
			//exit to prior menu
			studentVadmin(Storage, scan);
		}
		else if(answer.equals("exit")) {
			//exit to prior menu
			studentLogin(Storage,scan);
		}
		else {
			System.out.println("Please enter a number from 1 to 6");
			studentMenu(Storage,kid, scan);
		}
		//return to prior menu
		studentMenu(Storage,kid,scan);
	}
	
	//main menu method for admins
	public static void adminMenu(StoredLists Storage, Scanner scan) {
		Admin carl = new Admin(); //honestly I feel like the Admin class isn't necessary but I think cosmetically it looks more coherent
		System.out.println("Welcome back administrator.");
		System.out.println("Enter 'cm' for Course Management, 'r' for Reports, or 'exit' to exit: ");
		String bigAnswer = scan.nextLine();
		if(bigAnswer.equals("cm")) {//course management
			System.out.println("Enter '1' to Create a new course \n "
					+ "'2' to Delete a course \n "
					+ "'3' to Edit a course \n"
					+ "'4' to Display information on a course\n"
					+ "'5' to Register a Student \n"
					+ "or '6' to  Exit");
			String smolAnswer = scan.nextLine();
			if(smolAnswer.equals("1")) {
				//method to create course
				createCourse(Storage,scan);
			}
			else if(smolAnswer.equals("2")) {
				//method to delete coursescan
				deleteCourse(Storage,scan);
			}
			else if(smolAnswer.equals("3")) {
				//method to edit course
				System.out.println("Enter the course name of the course you want to edit:");
				String courseName = scan.nextLine();
				for(Course c:Storage.getCourseList()) {
					if(c.getCourseName().equals(courseName)) {
						editCourse(Storage, c,scan);
					}
				}
				System.out.println("Error, Course not found");
				adminMenu(Storage,scan);
				
			}
			else if(smolAnswer.equals("4")) {
				//method to display info on course
				System.out.println("Enter the course ID of the course you want to see:");
				String ID = scan.nextLine();
				for(Course c:Storage.getCourseList()) {
					if(c.getID() == Integer.parseInt(ID)) {
						c.fullViewPrint();
					}
				}
				System.out.println("Error, Course not found");
				adminMenu(Storage,scan);
			}
			else if(smolAnswer.equals("5")) {
				//method to register a student
				registration(Storage,scan);
			}
			else if(smolAnswer.equals("6")) {
				//exit to prior menu
				studentVadmin(Storage,scan);
			}
			else if(smolAnswer.equals("exit")) {
				//exit to prior menu
				studentVadmin(Storage,scan);
			}
			else {
				System.out.println("Please enter a number from 1 to 6");
				adminMenu(Storage,scan);
			}
		}
		else if(bigAnswer.equals("r")) {
			System.out.println("Enter '1' to View all courses \n "
					+ "'2' to View all courses that are at full student capacity \n "
					+ "'3' to Write to a file a list of courses that are full \n"
					+ "'4' to View the Names of the students being Registered in a specific course \n"
					+ "'5' to View the list of courses a specific student is registered in \n"
					+ "'6' to Sort the courses based on the current number of registered Students \n"
					+ "or '7' to  Exit");
			String smallAnswer = scan.nextLine();
			if(smallAnswer.equals("1")) {
				//method to view all courses
				Storage.viewAllCourses();
			}
			else if(smallAnswer.equals("2")) {
				//method to view all full courses
				Storage.viewAllFullCourses();
			}
			else if(smallAnswer.equals("3")) {
				//method to write that list into a file
				writtenList(Storage,scan);
			}
			else if(smallAnswer.equals("4")) {
				//method to view names of students in specific course
				
				//which course do you want the student roster from?
				System.out.println("Enter the course name of the course you want to see the Student Roster from:");
				String courseName = scan.nextLine();
				for(Course c:Storage.getCourseList()) {
					if(c.getCourseName().equals(courseName)) {
						try {
							for(String s: c.getNameRoster()){
								System.out.println(s);
							}
							adminMenu(Storage,scan);
						}
						catch (Exception ex) {
							System.out.println( "Error Showing Name Roster");
							ex.printStackTrace();
							adminMenu(Storage,scan);
						}
						
					}
				}
				System.out.println("Error, Course not found");
				adminMenu(Storage,scan);
			}
			else if(smallAnswer.equals("5")) {
				//method to view names of courses with specific student
				System.out.println("Enter student's first name:");
				String firstName = scan.nextLine();
				System.out.println("Enter student's last name:");
				String lastName = scan.nextLine();
				//The only decent method used by the Admin Class
				carl.showStudentCourses(firstName, lastName, Storage, scan);
				adminMenu(Storage,scan);
			}
			else if(smallAnswer.equals("6")) {
				//method to sort courses by registered students
				Storage.sortCourses();
			}
			else if(smallAnswer.equals("7")) {
				//exit to previous menu
				studentVadmin(Storage,scan);
			}
			else if(smallAnswer.equals("exit")) {
				//exit to previous menu
				studentVadmin(Storage,scan);
			}
			else {
				System.out.println("Please enter a number from 1 to 7");
				adminMenu(Storage,scan);
			}
		}
		else if(bigAnswer.equals("exit")) {
			//exit to previous menu
			studentVadmin(Storage,scan);
		}
		else {
			System.out.println("Please enter either lowercase cm or r");
			adminMenu(Storage,scan);
		}
		adminMenu(Storage,scan);
	}
	
	//the process of Registering for course for a student
	public static void registerTheKid(StoredLists Storage, Student kid, Scanner scan) {
		//course name, session and Kids full name to add onto the roster
		System.out.println("Enter course name:");
		String courseName = scan.nextLine();
		System.out.println("Enter course section:");
		String courseSection = scan.nextLine();
		System.out.println("Enter your Full Name:");
		String fullName = scan.nextLine();
		if(courseName.equals("exit")) {
			studentMenu(Storage,kid,scan);
		}
		for(Course c:Storage.getCourseList()) {
			if(c.getCourseName().equals(courseName) && c.getSectionNum() == Integer.parseInt(courseSection)) {
				if(c.getMaxStudents()>c.getRegistered()) {
					c.addToRoster(fullName);
					c.setRegistered(c.getRegistered()+1);
					kid.addToCourseList(c);
					System.out.println("Student Registered!");
					studentMenu(Storage,kid,scan);
				}
				else{
					System.out.println("Error, Course is full");
					studentMenu(Storage,kid,scan);
				}
			}
		}
		System.out.println("Error, Course not found");
		studentMenu(Storage,kid,scan); //return to Student Menu
	}
	//process of withdrawing from a course
	public static void withdrawTheCourse(StoredLists Storage, Student kid, Scanner scan) {
		//just student name and course
		System.out.println("Enter your Full Name:");
		String fullName = scan.nextLine();
		System.out.println("Enter course name:");
		String courseName = scan.nextLine();
		if(fullName.equals("exit")) {
			studentMenu(Storage,kid,scan);
		}
		for(Course c:Storage.getCourseList()) {
			if(c.getCourseName().equals(courseName)) {
				c.removeFromRoster(fullName);
				c.setRegistered(c.getRegistered()-1);
				kid.deleteCourse(c);
				System.out.println("Student Withdrawn!");
				return;
			}
		}
		System.out.println("Error, Course not found");
		studentMenu(Storage,kid,scan); //return to Student Menu
	}
	
	//Admin creating a course
	public static void createCourse(StoredLists Storage,Scanner scan) {
		//all the relevant parameters for a course
		System.out.println("Enter course name:");
		String courseName = scan.nextLine();
		System.out.println("Enter course ID:");
		String ID = scan.nextLine();
		System.out.println("Enter courses' Max capacity for students:");
		String maxStudents = scan.nextLine();
		System.out.println("Enter number of currently registered students:");
		String registered = scan.nextLine();
		System.out.println("Enter the names of the registered students separated by a comma:");
		String nameRoster = scan.nextLine();
		System.out.println("Enter instructor name:");
		String instructor = scan.nextLine();
		System.out.println("Enter course section:");
		String courseSection = scan.nextLine();
		System.out.println("Enter course location:");
		String location = scan.nextLine();
		if(courseName.equals("exit")) {
			adminMenu(Storage,scan);
		}
		
		try {
			ArrayList<String> roster = new ArrayList<String>();
			String[] names = nameRoster.split(",");
			for(String s: names) {
				roster.add(s);
			}
		
			//and now we've constructed a new course and add it to the list of courses
			Course newThing = new Course(courseName, Integer.parseInt(ID), 
					Integer.parseInt(maxStudents), Integer.parseInt(registered), 
					roster, instructor, Integer.parseInt(courseSection), location);
			Storage.addCourse(newThing);
			System.out.println("Course Created!");
			return;
		}
		catch (Exception ex) {
			System.out.println( "Error creating Course");
			ex.printStackTrace();
			adminMenu(Storage,scan);
		}
		
	}
	//Admin deleting a course
	public static void deleteCourse(StoredLists Storage,Scanner scan) {
		//take the course name to choose which course to delete
		System.out.println("Enter course name:");
		String courseName = scan.nextLine();
		if(courseName.equals("exit")) {
			adminMenu(Storage,scan);
		}
		for(Course c:Storage.getCourseList()) {
			if(c.getCourseName().equals(courseName)) {
				c.removeFromRoster(courseName);
				Storage.deleteCourse(c);
				System.out.println("Course Deleted");
				return;
			}
		}
		System.out.println("Error, Course not found");
		adminMenu(Storage,scan);
		
	}
	//Admind editing a course
	public static void editCourse(StoredLists Storage, Course c, Scanner scan) {
		//figure out which part to edit
		System.out.println("Enter '1' to edit the Maximum Students number \n "
				+ "'2' to edit the number of Registered Students \n "
				+ "'3' to edit the Student Roster \n"
				+ "'4' to edit the instructor name \n"
				+ "'5' to edit the Section Number \n"
				+ "'6' to edit the location \n"
				+ "or '7' to  Exit");
		String answer = scan.nextLine();
		if(answer.equals("1")) {
			//method to edit the max students
			System.out.println("Enter courses' Max capacity for students:");
			String maxStudents = scan.nextLine();
			c.setMaxStudents(Integer.parseInt(maxStudents));
			System.out.println("Max Students is now: "+ c.getMaxStudents());
			editCourse(Storage, c,scan);
			
		}
		else if(answer.equals("2")) {
			//method to edit number of currenty registered students
			System.out.println("Enter number of currently registered students:");
			String registered = scan.nextLine();
			c.setRegistered(Integer.parseInt(registered));
			System.out.println("Number of Registered Students is now: "+ c.getRegistered());
			editCourse(Storage, c,scan);
		}
		else if(answer.equals("3")) {
			//method to edit the name roster
			System.out.println("Enter the names of the registered students separated by a comma:");
			String nameRoster = scan.nextLine();
			try {
				ArrayList<String> roster = new ArrayList<String>();
				String[] names = nameRoster.split(",");
				for(String s: names) {
					roster.add(s);
				}
				c.setNameRoster(roster);
				System.out.println("Name Roster is now is now: "+ c.getNameRoster());
				adminMenu(Storage,scan);
			}
			catch (Exception ex) {
				System.out.println( "Error editing Course");
				ex.printStackTrace();
				adminMenu(Storage,scan);
			}
		}
		else if(answer.equals("4")) {
			//method to edit instructor Name
			System.out.println("Enter instructor name:");
			String instructor = scan.nextLine();
			c.setInstructor(instructor);
			System.out.println("Course instructor is now: "+ c.getInstructor());
			editCourse(Storage, c,scan);
		}
		else if(answer.equals("5")) {
			//method to edit Course Section
			System.out.println("Enter course section:");
			String courseSection = scan.nextLine();
			c.setSectionNum(Integer.parseInt(courseSection));
			System.out.println("Course section number is now: "+ c.getSectionNum());
			editCourse(Storage, c,scan);
		}
		else if(answer.equals("6")) {
			//method to edit Course Location
			System.out.println("Enter course location:");
			String location = scan.nextLine();
			c.setLocation(location);
			System.out.println("Course location is now: "+ c.getLocation());
			editCourse(Storage, c,scan);
		}
		else if(answer.equals("7")) {
			//exit to previous menu
			adminMenu(Storage,scan);
		}
		else if(answer.equals("exit")) {
			//exit to previous menu
			adminMenu(Storage,scan);
		}
		else {
			System.out.println("Please enter a number from 1 to 7");
			editCourse(Storage, c,scan);
		}
	}
	
	//register a student into the list of students
	public static void registration(StoredLists Storage,Scanner scan) {
		//all the relevant parameters for a new student
				System.out.println("Enter student's username:");
				String username = scan.nextLine();
				System.out.println("Enter student's password:");
				String password = scan.nextLine();
				System.out.println("Enter student's first name:");
				String firstName = scan.nextLine();
				System.out.println("Enter student's last name:");
				String lastName = scan.nextLine();
				if(username.equals("exit")) {
					adminMenu(Storage,scan);
				}
				
				try {
					//and now we've constructed a new course and add it to the list of courses
					Student newKid = new Student(username, password, firstName, lastName);
					Storage.addStudent(newKid);
					System.out.println("New Student Registered!");
					return;
				}
				catch (Exception ex) {
					System.out.println( "Error Registering Student");
					ex.printStackTrace();
					adminMenu(Storage,scan);
				}
	}
	
	//writting the list of Full Courses to a text file
	public static void writtenList(StoredLists Storage, Scanner scan) {
		String fileName = "text.txt";
		try{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String text = "";
			for(Course c: Storage.getCourseList()) {
				if(c.getMaxStudents()==c.getRegistered()) {
					text = text + c.getPrint();
				}
			}
			bufferedWriter.write(text);
			bufferedWriter.newLine();

			
			//Always close writer
			bufferedWriter.close();
			System.out.println("Course list Written!");
		}
		catch (IOException exk) {
			System.out.println( "Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
		//Always close files
		adminMenu(Storage, scan);
	}
	//THE SERIALIZATION ZONE
		public static void serialize(StoredLists Storage) {
			try {
				StoredLists serializedLists = new StoredLists(true, Storage.getStudentList(), Storage.getCourseList());
				//FileOutput Stream writes data to a file
				FileOutputStream fos = new FileOutputStream("Stored.ser");
				
				//ObjectOutputStream writes objects to a stream (A sequence of data)
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				//Writes the specific object to the OOS
				oos.writeObject(serializedLists);
				
				//Close both streams
				oos.close();
				fos.close();
				System.out.println("Serialization complete");
			} 
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
		//Access the Lists
		public static void deserialize(StoredLists Storage) {   
			try{
				 StoredLists store = null;
				 //FileInputSystem recieves bytes from a file
				 FileInputStream fis = new FileInputStream("Stored.ser");
				      
				 //ObjectInputStream does the deserialization-- it reconstructs the data into an object
				 ObjectInputStream ois = new ObjectInputStream(fis);
				      
				 //Cast as . readObject will take the object from ObjectInputStream
			     store = (StoredLists)ois.readObject();
				 ois.close();
				 fis.close();
				 Storage.setStudentList(store.getStudentList());
				 System.out.println("students deserialized");
				 Storage.setCourseList(store.getCourseList());
				 System.out.println("courses deserialized");
			}
			catch(IOException ioe) {
				 ioe.printStackTrace();
				 return;
			}
			catch(ClassNotFoundException cnfe) {
				 cnfe.printStackTrace();
				 return;
			}//maybe do some system.out.println to show that the deserialization worked?

		}
}
