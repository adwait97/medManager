import static org.junit.Assert.*;

import org.junit.Test;

public class MedicationTest {

	@Test
	public void test() {
		Medications.setName("Allen");
		assertEquals("Allen",Medications.getName());
	}
	
	@Test
	public void test_2() {
		Medications.setName("Mark");
		assertEquals("Mark",Medications.getName());
	}
	@Test
	public void test_3() {
		Medications.setNdc(1234);
		assertEquals(1234,Medications.getNdc());
	}
	@Test
	public void test_4() {
		Medications.setStrength(100);
		assertEquals(100,Medications.getStrength());
	}
	@Test
	public void test_5() {
		Medications.setStrength(500);
		assertEquals(500,Medications.getStrength());
	}
	@Test
	public void test_6() {
		Medications.setQuantity(1000);
		assertEquals(1000,Medications.getQuantity());
	}
	@Test
	public void test_7() {
		Medications.setSchedule("C-V");
		assertEquals("C-V",Medications.getSchedule());
	}

}
