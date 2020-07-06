package models;

public class Managers {
	
	public int managerid;
	public String firstname;
	public String lastname;
	public String password;
	public String email;
	
	public Managers() {};
	
	public Managers(int managerid, String firstname) {
		this.managerid = managerid;
		this.firstname = firstname;
	}
	
	public Managers(int managerid, String firstname, String lastname, String password, String email) {
		super();
		this.managerid = managerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}

	//getters and setters for Java Bean
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	
}
