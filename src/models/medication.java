package models;

public class medication {
	public int medicationID;
	public String Name;
	public String NDC;
	public String Strength;
	public String Schedule;
	public String Quantity;
	
	
	
	public medication() {
	}



	public medication(String name, String nDC, String strength, String schedule, String quantity) {
		Name = name;
		NDC = nDC;
		Strength = strength;
		Schedule = schedule;
		Quantity = quantity;
	}



	public int getMedicationID() {
		return medicationID;
	}



	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}



	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getNDC() {
		return NDC;
	}



	public void setNDC(String nDC) {
		NDC = nDC;
	}



	public String getStrength() {
		return Strength;
	}



	public void setStrength(String strength) {
		Strength = strength;
	}



	public String getSchedule() {
		return Schedule;
	}



	public void setSchedule(String schedule) {
		Schedule = schedule;
	}



	public String getQuantity() {
		return Quantity;
	}



	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	
	
	
	
}
