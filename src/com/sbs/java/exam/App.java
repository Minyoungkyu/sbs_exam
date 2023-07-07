package com.sbs.java.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sbs.java.exam.controller.*;
import com.sbs.java.exam.dto.Member;
import com.sbs.java.exam.dto.Article;
import com.sbs.java.exam.controller.MenuController;
import com.sbs.java.exam.util.Util;

public class App {
	public void start() {

		Scanner sc = new Scanner(System.in);

		System.out.println("== 프로그램 시작 == \n");
		MenuController.showMenu();

		ArticleController articleController = new ArticleController();
		MemberController memberController = new MemberController();

		while1 : while (true) {
			System.out.printf("원하는 메뉴를 입력하세요 >> ");

			String input = sc.next();
			sc.nextLine();
			int command = -1;
			Controller controller;

			if (Util.isNum(input)) {
				command = Integer.parseInt(input);
			} else {
				System.out.println("잘못된 입력입니다. 메뉴에 해당하는 숫자를 입력하세요.\n");
				System.out.println();

				continue;
			}

			if (!MenuController.isInMenu(command)) {
				System.out.println("없는 메뉴 입니다. 메뉴를 정확히 입력하세요.\n");
				System.out.println();

				continue;
			}

			if (command == 0) { // 프로그램 종료
				if(MenuController.checkMenuOff()) break;
			} else if (command == 9) {
				MenuController.showMenu();
			} else { // 메뉴 변경시 수정(시작) - MenuController 도 수정.
				if(command <= 6) controller = articleController;
				else controller = memberController;
				controller.doAction(command);
			} // 메뉴 변경시 수정(끝)
		} // while 끝


	} // main 끝
}
