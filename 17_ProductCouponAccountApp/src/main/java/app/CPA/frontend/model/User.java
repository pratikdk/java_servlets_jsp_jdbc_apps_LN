package app.CPA.frontend.model;

public class User implements AccountHolder {
	private int userId;
	private String username;
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "<h2>User</h2> <br/>userId=" + userId + ", <br/>username=" + username;
	}
	
}
