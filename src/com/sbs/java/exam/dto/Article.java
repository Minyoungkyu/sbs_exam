package com.sbs.java.exam.dto;

public class Article {
	public int number;
	public String title;
	public String body;
	public String date;
	public int hit;
	public String writeId;

	public Article(int number, String title, String body, String date, String id) {
		this.number = number;
		this.title = title;
		this.body = body;
		this.date = date;
		this.hit = 0;
		this.writeId = id;
	}
	
	public void increaseHit() {
		this.hit++;
	}
}