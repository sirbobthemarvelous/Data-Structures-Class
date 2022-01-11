package midterm;

public abstract class Use {

	private String password;
	private String firstName;
	private String lastName;

	//Getter methods
	public abstract String getUsername();
	
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
	public abstract void setUsername(String name);
	
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
