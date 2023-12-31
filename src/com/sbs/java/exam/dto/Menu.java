package com.sbs.java.exam.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private List<Integer> menu = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9); // 메뉴 추가 시 수정!!
    
    public void showMenu() { // 메뉴 변경시 수정!
        System.out.println("<메뉴>");
        System.out.println("1. 게시글 작성");
        System.out.println("2. 게시글 목록");
        System.out.println("3. 게시글 검색");
        System.out.println("4. 게시글 열기");
        System.out.println("5. 게시글 수정");
        System.out.println("6. 게시글 삭제");
        System.out.println("7. 로그인/로그아웃");
        System.out.println("8. 회원 가입");
        System.out.println("9. 메뉴 다시보기");
        System.out.println("0. 프로그램 종료\n");
    }

    public boolean isInMenu(int command) {
        if(menu.contains(command)) return true;
        else return false;
    }

    public boolean checkMenuOff() {
        while(true) {
            System.out.print("정말 프로그램을 종료하시겠습니까? (y/n) >> ");
            String yesOrNo = sc.nextLine();
            yesOrNo.toLowerCase();
            if (yesOrNo.length() != 1) {
                System.out.println("y 또는 n 을 입력 해주세요.");
                System.out.println();
                continue;
            } else {
                if(yesOrNo.equals("y")) {
                    System.out.println("== 프로그램 종료 ==");
                    sc.close();
                    return true;

                } else if (yesOrNo.equals("n")) {
                    System.out.println();
                    return false;
                } else {
                    System.out.println("y 또는 n 을 입력해주세요.");
                    System.out.println();
                    continue;
                }
            }
        }

    }

}

