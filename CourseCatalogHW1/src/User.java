
abstract class User { //using an abstract class, its still inheritable
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	User(){
		//an empty constructor
	}
	
	//constructor with relevant information
	public User(String u, String p, String first, String last) {
		username = u;
		password = p;
		firstName = first;
		lastName = last;
	}
	//Getter methods
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
	//Setter methods
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
	
}
