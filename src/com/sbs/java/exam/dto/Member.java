package com.sbs.java.exam.dto;

public class Member {
	public static int lastMemberNumber = 1;
	public int num;
	public String id;
	public String pw;
	public String date;
	public String name;
	
	public Member(String id, String pw, String date, String name) {
		this.id = id;
		this.pw = pw;
		this.date = date;
		this.name = name;
		this.num = lastMemberNumber;

		lastMemberNumber++;
	}
	
	
}
