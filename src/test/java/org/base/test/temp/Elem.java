package org.base.test.temp;

public class Elem {

	private int id;
	
	private String a_value;
	
	private String z_value;
	
	private int from;
	
	private int end;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getA_value() {
		return a_value;
	}

	public void setA_value(String a_value) {
		this.a_value = a_value;
	}

	public String getZ_value() {
		return z_value;
	}

	public void setZ_value(String z_value) {
		this.z_value = z_value;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Elem(String a_value, String z_value) {
		super();
		this.a_value = a_value;
		this.z_value = z_value;
	}
	
	public Elem(){
		
	}

	@Override
	public String toString() {
		return this.getId()+"["+this.getA_value()+","+this.getZ_value()+"]";
	}
	
	
}
