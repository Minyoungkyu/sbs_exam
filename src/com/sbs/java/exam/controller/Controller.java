package com.sbs.java.exam.controller;

import java.util.Scanner;

public abstract class Controller {
    public Scanner sc = new Scanner(System.in);

    public abstract void doAction(int command);



}
