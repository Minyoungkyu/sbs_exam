package com.sbs.java.exam.controller;

import java.util.Scanner;

import com.sbs.java.exam.dto.Member;

public abstract class Controller {
	public static Member loginedMember;
	
	public static boolean isLogin() {
    	if(loginedMember != null) return true;
    	return false;
    }
	
    public Scanner sc = new Scanner(System.in);

    public abstract void doAction(int command);



}
