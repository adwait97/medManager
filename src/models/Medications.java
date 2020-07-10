package models;

public class Medications{
	
	public String name;
	public long ndc;
	public int strength;
	public int quantity;
	public String schedule;
	
	public Medications() {}
	
	public Medications(long ndc) {
		this.ndc = ndc;
	}
	
	public Medications(String name, long ndc, int strength, int quantity, String schedule) {
		super();
		this.name = name;
		this.ndc = ndc;
		this.strength = strength;
		this.quantity = quantity;
		this.schedule = schedule;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNdc() {
		return ndc;
	}
	public void setNdc(long ndc) {
		this.ndc = ndc;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	
	
}
