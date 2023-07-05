package com.sbs.java.exam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static void main(String[] args) {



    }

    public static boolean isNum(String str) { // 숫자(int) 잡기 method
        try {
            Integer i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

}
