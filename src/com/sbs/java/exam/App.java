package com.sbs.java.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sbs.java.exam.dto.Article;
import com.sbs.java.exam.util.Util;

public class App {
	public void start() {

		Scanner sc = new Scanner(System.in);

		System.out.println("== 프로그램 시작 == \n"); // 메뉴 추가 시 수정!!
		System.out.println("<메뉴>");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록");
		System.out.println("3. 게시글 열기");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("0. 프로그램 종료\n");

		List<Article> articles = new ArrayList<>(); // 게시글 리스트
		int lastArticleNumber = 0;

		while (true) {
			System.out.printf("원하는 메뉴를 입력하세요 >> ");
			List<Integer> menu = Arrays.asList(0, 1, 2, 3, 4, 5); // 메뉴 추가 시 수정!!

			String input = sc.next();
			sc.nextLine();
			int command = -1;

			if (Util.isNum(input)) {
				command = Integer.parseInt(input);
			} else {
				System.out.println("잘못된 입력입니다. 메뉴에 해당하는 숫자를 입력하세요.\n");
				System.out.println();

				continue;
			}

			if (!menu.contains(command)) {
				System.out.println("없는 메뉴 입니다. 메뉴를 정확히 입력하세요.\n");
				System.out.println();

				continue;
			}

			if (command == 0) { // 프로그램 종료
				System.out.println();
				System.out.println("== 프로그램 종료 ==");
				sc.close();
				break;
			} else if (command == 1) { // 게시글 작성
				lastArticleNumber++;
				System.out.println("<게시글 작성>");
				System.out.printf("제목입력 >> ");
				String title = sc.nextLine();
				System.out.printf("내용입력 >> ");
				String body = sc.nextLine();
				String date = Util.getDateTime();

				articles.add(new Article(lastArticleNumber, title, body, date));

				System.out.println("게시글이 작성되었습니다. (게시글번호 : " + lastArticleNumber + " 번 )");
				System.out.println();

			} else if (command == 2) { // 게시글 목록
				System.out.println("<게시글 목록>");
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					System.out.println();

				}
				List<Article> reversedArticles = new ArrayList<>(articles);
				Collections.reverse(reversedArticles);
				for (Article a : reversedArticles) {
					System.out.println(a.number + "번 게시글 " + "( 제목 : " + a.title + " )" + " ( 조회수 : " + a.hit + " ) ");

				}
				System.out.println();
			} else if (command == 3) { // 게시글 열기
				System.out.println("<게시글 열기>");
				System.out.printf("게시글 번호(제목) 입력 >> ");
				String articleTitle = sc.nextLine();
				int articleIndex = -1;
				if (Util.isNum(articleTitle)) { // 번호를 입력받았다면
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).number == Integer.parseInt(articleTitle)) {
							articleIndex = i;
						}
					} // for문 끝
					if (articleIndex == -1) {
						System.out.println("잘못된 게시글 번호(제목)입니다.");
						System.out.println();

					} else {
						articles.get(articleIndex).increaseHit();

						System.out.println(
								articles.get(articleIndex).number + "번 게시글 ( 조회수 : " + articles.get(articleIndex).hit
										+ " ) " + " (작성시간 : " + articles.get(articleIndex).date + " )");
						System.out.println("제목 : " + articles.get(articleIndex).title);
						System.out.println("내용 : " + articles.get(articleIndex).body);
						System.out.println();

					}
				} else { // 글자를 입력받았다면
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).title.equals(articleTitle)) {
							articleIndex = i;
						}
					} // for문 끝
					if (articleIndex == -1) {
						System.out.println("잘못된 게시글 번호(제목)입니다.");
						System.out.println();

					} else {
						articles.get(articleIndex).increaseHit();

						System.out.println(
								articles.get(articleIndex).number + "번 게시글 ( 조회수 : " + articles.get(articleIndex).hit
										+ " ) " + " (작성시간 : " + articles.get(articleIndex).date + " )");
						System.out.println("제목 : " + articles.get(articleIndex).title);
						System.out.println("내용 : " + articles.get(articleIndex).body);
						System.out.println();

					}
				}
			} else if (command == 4) { // 게시글 수정
				System.out.println("<게시글 수정>");
				System.out.printf("게시글 번호(제목) 입력 >> ");
				String articleTitle = sc.nextLine();
				int articleIndex = -1;
				if (Util.isNum(articleTitle)) { // 번호를 입력받았다면
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).number == Integer.parseInt(articleTitle)) {
							articleIndex = i;
						}
					} // for문 끝
					if (articleIndex == -1) {
						System.out.println("잘못된 게시글 번호(제목)입니다.");
					} else {
						System.out.print("새로운 제목 >> ");
						String title = sc.nextLine();
						articles.get(articleIndex).title = title;
						System.out.print("새로운 내용 >> ");
						String body = sc.nextLine();
						articles.get(articleIndex).body = body;

						System.out.println(articles.get(articleIndex).number + " 번 게시글이 수정되었습니다.");
						System.out.println();
					}
				} else { // 글자를 입력받았다면
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).title.equals(articleTitle)) {
							articleIndex = i;
						}
					} // for문 끝
					if (articleIndex == -1) {
						System.out.println("잘못된 게시글 번호(제목)입니다.");
					} else {
						System.out.print("새로운 제목 >> ");
						String title = sc.nextLine();
						articles.get(articleIndex).title = title;
						System.out.print("새로운 내용 >> ");
						String body = sc.nextLine();
						articles.get(articleIndex).body = body;

						System.out.println(articles.get(articleIndex).number + " 번 게시글이 수정되었습니다.");
						System.out.println();
					}
				}

			} else if (command == 5) {
				System.out.println("<게시글 삭제>");
				System.out.printf("게시글 번호(제목) 입력 >> ");
				String articleTitle = sc.nextLine();
				int articleIndex = -1;
				if (Util.isNum(articleTitle)) { // 번호를 입력받았다면
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).number == Integer.parseInt(articleTitle)) {
							articleIndex = i;
						}
					} // for문 끝
					if (articleIndex == -1) {
						System.out.println("잘못된 게시글 번호(제목)입니다.");
					} else {
						articles.remove(articleIndex);
						System.out.println("게시글이 삭제되었습니다.");
						System.out.println();

					}
				} else { // 글자를 입력받았다면
					for (int i = 0; i < articles.size(); i++) {
						if (articles.get(i).title.equals(articleTitle)) {
							articleIndex = i;
						}
					} // for문 끝
					if (articleIndex == -1) {
						System.out.println("잘못된 게시글 번호(제목)입니다.");
					} else {
						articles.remove(articleIndex);
						System.out.println("게시글이 삭제되었습니다.");
						System.out.println();

					}
				}
			} // else if
		} // while 끝

	} // main 끝
}
