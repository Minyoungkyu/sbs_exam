package com.sbs.java.exam.controller;

import com.sbs.java.exam.dto.Article;
import com.sbs.java.exam.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleController extends Controller{
    public static int lastArticleNumber = 0;
    private List<Article> articles;

    public ArticleController() {
        articles = new ArrayList<>();
    }

    @Override
    public void doAction(int command) {
        switch (command) {
            case 1 : this.doArticleWrite();
            break;
            case 2 : this.showArticleList();
            break;
            case 3 : this.doArticleSearch();
            break;
            case 4 : this.showArticleDetail();
            break;
            case 5 : this.doArticleModify();
            break;
            case 6 : this.doArticleDelete();
            break;
        }
    }

    public void doArticleWrite() {
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
    }

    public void showArticleList() {
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
    }

    public void doArticleSearch() {
        System.out.println("<게시글 검색>");
        System.out.printf("검색 내용 입력 >> ");
        String searchKey = sc.nextLine();
        System.out.println("검색 결과");
        int count = 0;
        for (Article a : articles) {
            if (a.title.contains(searchKey)) {
                System.out.println(
                        a.number + "번 게시글 " + "( 제목 : " + a.title + " )" + " ( 조회수 : " + a.hit + " ) ");
            } else if (a.body.contains(searchKey)) {
                System.out
                        .println(a.number + "번 게시글 " + "( 내용 : " + a.body + " )" + " ( 조회수 : " + a.hit + " ) ");
            } else
                count++;

        }
        if (count == articles.size()) {
            System.out.println("검색된 게시글이 없습니다.");
        }
        System.out.println();
    }

    public void showArticleDetail() {
        System.out.println("<게시글 열기>");
        System.out.printf("게시글 번호(제목) 입력 >> ");
        String articleTitle = sc.nextLine();
        int articleIndex = getArticleIndex(articles, articleTitle);

        if (articleIndex == -1) {
            System.out.println("잘못된 게시글 번호(제목)입니다.");
            System.out.println();
            return;
        }
        articles.get(articleIndex).increaseHit();

        System.out.println(articles.get(articleIndex).number + "번 게시글 ( 조회수 : " + articles.get(articleIndex).hit
                + " ) " + " (작성시간 : " + articles.get(articleIndex).date + " )");
        System.out.println("제목 : " + articles.get(articleIndex).title);
        System.out.println("내용 : " + articles.get(articleIndex).body);
        System.out.println();
    }

    public void doArticleModify() {
        System.out.println("<게시글 수정>");
        System.out.printf("게시글 번호(제목) 입력 >> ");
        String articleTitle = sc.nextLine();
        int articleIndex = getArticleIndex(articles, articleTitle);

        if (articleIndex == -1) {
            System.out.println("잘못된 게시글 번호(제목)입니다.");
            return;
        }

        System.out.print("새로운 제목 >> ");
        String title = sc.nextLine();
        articles.get(articleIndex).title = title;
        System.out.print("새로운 내용 >> ");
        String body = sc.nextLine();
        articles.get(articleIndex).body = body;

        System.out.println(articles.get(articleIndex).number + " 번 게시글이 수정되었습니다.");
        System.out.println();
    }

    public void doArticleDelete() {
        System.out.println("<게시글 삭제>");
        System.out.printf("게시글 번호(제목) 입력 >> ");
        String articleTitle = sc.nextLine();
        int articleIndex = getArticleIndex(articles, articleTitle);

        if (articleIndex == -1) {
            System.out.println("잘못된 게시글 번호(제목)입니다.");
            return;
        }

        articles.remove(articleIndex);
        System.out.println("게시글이 삭제되었습니다.");
        System.out.println();
    }
    private int getArticleIndex(List<Article> articles, String articleTitle) {
        if (Util.isNum(articleTitle)) { // 번호를 입력받았다면
            for (int i = 0; i < articles.size(); i++) {
                if (articles.get(i).number == Integer.parseInt(articleTitle)) {
                    return i;
                }
            }//for문 끝
        } else { // 글자를 입력받았다면
            for (int i = 0; i < articles.size(); i++) {
                if (articles.get(i).title.equals(articleTitle)) {
                    return i;
                }
            } // for문 끝

        }
        return -1;
    } // getARticleIndex
}
