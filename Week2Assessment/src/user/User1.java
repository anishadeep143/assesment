package user;

public class User1 {
	private int loginid;
	private String password;
	private String email;
	
	//constructor
	public User1(int loginid, String password, String email) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.email = email;
	}
	
	//getters and setters
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	//to string method
	@Override
	public String toString() {
		return "User1 [loginid=" + loginid + ", password=" + password + ", email=" + email + "]";
	}
	

}
