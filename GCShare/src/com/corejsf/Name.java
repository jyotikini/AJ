package com.corejsf;

import java.io.Serializable;

public class Name {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int filenum;
	private String last;
	private String displayall="";
	private String displaylink="";
	
	public String getDisplayall() {
		if(filenum<5)
		{
			displayall = "displayfive";
		}
		
		return displayall;
	}
	
	public int getFilenum() {
		System.out.println("filenumber:" +filenum);
		return filenum;
	}
	public void setFilenum(int filenum) {
		System.out.println("filenumber:" +filenum);
		this.filenum = filenum;
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
