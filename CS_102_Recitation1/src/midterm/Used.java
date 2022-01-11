package midterm;

public class Used extends Use {

	private String username;
	
	Used(String u){
		username = u;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public void setUsername(String name) {
		// TODO Auto-generated method stub
		username = name;
	}

}
