package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManagersTest {
	Managers m = new Managers();

	@Test
	public void testGetManagerid() {
		Managers.setManagerid(5);
		assertEquals(5, Managers.getManagerid());
	}

	@Test
	public void testGetFirstname() {
		Managers.setFirstname("Fayyad");
		assertEquals("Fayyad", Managers.getFirstname());
	}

	@Test
	public void testGetLastname() {
		Managers.setLastname("Choudhury");
		assertEquals("Choudhury", Managers.getLastname());
	}

	@Test
	public void testGetEmail() {
		Managers.setEmail("fayyad@gmail.com");
		assertEquals("fayyad@gmail.com", Managers.getEmail());
	}

	@Test
	public void testGetPassword() {
		Managers.setPassword("password");
		assertEquals("password", Managers.getPassword());
	}
	
	@Test
	public void testConstructor() {
		new Managers(10, "Deandre", "Hopkins", "deandre@gmail.com", "password");
		assertEquals(10, Managers.getManagerid());
		assertEquals("Deandre", Managers.getFirstname());
		assertEquals("Hopkins", Managers.getLastname());
		assertEquals("deandre@gmail.com", Managers.getEmail());
		assertEquals("password", Managers.getPassword());
	}
}
