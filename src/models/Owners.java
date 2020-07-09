package models;

public class Owners implements Workers{
	public int managerid;
	
	public Owners() {}
	
	public Owners(int managerid) {
		this.managerid = managerid;
	}
	@Override
	public String getDuty() {
		// TODO Auto-generated method stub
		return "{id: "+managerid+"} Owner view";
	}

}
