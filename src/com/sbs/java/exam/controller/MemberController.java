package com.sbs.java.exam.controller;

import com.sbs.java.exam.dto.Member;
import com.sbs.java.exam.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MemberController extends Controller{
    private List<Member> members;

    public MemberController() {
        members = new ArrayList<>();
    }

    @Override
    public void doAction(int command) {
        switch (command) {
            case 8 : this.doMemberJoin();
            break;
        }
    }

    public void doMemberJoin() {
        System.out.println("<회원 가입>");
        System.out.print("이름 입력 >> ");
        String name = sc.nextLine();
        String id = null;
        while (true) {
            System.out.print("ID 입력 >> ");
            id = sc.nextLine();
            if(id.isEmpty()) continue;

            if(checkMembersId(members, id) == true) {
                System.out.println(id + " 는 이미 사용중인 id 입니다.");
                continue;
            }

            break;
        }
        String pw = null;
        while(true) {
            System.out.print("Pw 입력 >> ");
            pw = sc.nextLine();
            System.out.print("Pw 확인 >> ");
            String checkPw = sc.nextLine();

            if(pw.equals(checkPw)) {
                break;
            }
            System.out.println("비밀번호가 다릅니다. 다시 입력해주세요");
        }
        String date = Util.getDateTime();

        members.add(new Member(id, pw, date, name));
        System.out.println(id + "(님)의 회원가입이 완료되었습니다.");
        System.out.println();
    }

    private boolean checkMembersId(List<Member> members, String id) {
        for(Member m : members) {
            if(m.id.equals(id)) {
                return true;
            }
        } // for문 끝
        return false;
    } // checkMembersId
}
