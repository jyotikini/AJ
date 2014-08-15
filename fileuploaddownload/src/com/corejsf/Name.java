package com.corejsf;

import java.io.Serializable;

public class Name {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String first;
	private String last;
	
	public String getFirst() {
//		System.out.println("Name.getfirst");
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	//	System.out.println("Name.setfirst");
	}
	public String getLast() {
	//	System.out.println("Name.getlast");
		return last;
	}
	public void setLast(String last) {
		this.last = last;
		//System.out.println("Name.setlast");
	}


}
