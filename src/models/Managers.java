package models;

public class Managers {
	
	public static int managerid;
	public static String firstname;
	public static String lastname;
	public static String password;
	public static String email;
	
	public Managers() {}
	
	public Managers(int managerId, String firstName) {
		managerid = managerId;
		firstname = firstName;
	}
	
	public Managers(int managerId, String firstName, String lastName, String Email, String Password) {
		super();
		managerid = managerId;
		firstname = firstName;
		lastname = lastName;
		password = Password;
		email = Email;
	}

	//getters and setters for Java Bean
	public static int getManagerid() {
		return managerid;
	}
	public static void setManagerid(int managerId) {
		managerid = managerId;
	}
	public static String getFirstname() {
		return firstname;
	}
	public static void setFirstname(String firstName) {
		firstname = firstName;
	}
	public static String getLastname() {
		return lastname;
	}
	public static void setLastname(String lastName) {
		lastname = lastName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String Password) {
		password = Password;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String Email) {
		email = Email;
	}
	
}
