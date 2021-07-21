package app.CPA.frontend.model;

public class Supplier implements AccountHolder {
	private int supplierId;
	private String username;
	private String password;
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
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
		return "<h2>Supplier</h2> <br/>supplierId=" + supplierId + ", <br/>username=" + username;
	}
}
