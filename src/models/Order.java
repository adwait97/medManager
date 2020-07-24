package models;

import java.util.Date;

public class Order {
	int orderid;
	String customername;
	long ndc;
	String email;
	int quantity;
	int strength;
	Date date;
	
	public void Orders(int orderid, String customername, long ndc, String email, int quantity, Date date, int strength) {
		this.orderid = orderid;
		this.customername = customername;
		this.ndc = ndc;
		this.email = email;
		this.quantity = quantity;
		this.strength = strength;
		this.date = date;
	}
	
	public int getOrderid(int orderid) {
		return orderid;
	}
	
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public String getCustomername(String customername) {
		return customername;
	}
	
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public long getNdc(long ndc) {
		this.ndc = ndc;
		return ndc;
	}

	public void setNdc(long ndc) {
		this.ndc = ndc;
	}
	
	public String getEmail(String email) {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getQuantity(int quantity) {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getStrength(int strength) {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public String getDate() {
		return date.toString().substring(0,10);
	}
}
