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
            
            case 7 : this.doMemberLoginOrLogout();
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

            if(checkMembersId(id) == true) {
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
    
    public void doMemberLoginOrLogout() {
    	if(isLogin()) {
    		loginedMember = null;
    		System.out.println("로그아웃 되었습니다.");
    	} else {
    		System.out.println("<로그인>");
        	System.out.print("로그인 아이디 : ");
        	String loginId = sc.nextLine();
        	if(checkMembersId(loginId)) {
        		System.out.print("로그인 비밀번호 : ");
        		Member loginMember = getLoginMember(loginId);
        		String loginPw = sc.nextLine();
        		if(loginMember.pw.equals(loginPw)) {
        			System.out.println(loginMember.name + " 님 환영합니다.\n");
        		} else System.out.println("비밀번호가 틀렸습니다.\n");
        		
        	} else {
        		System.out.println("존재하지 않는 아이디 입니다.\n");
        	}
        	
        	loginedMember = getLoginMember(loginId);
    	}
    }

    private boolean checkMembersId(String id) {
        for(Member m : members) {
            if(m.id.equals(id)) {
                return true;
            }
        } // for문 끝
        return false;
    } // checkMembersId
    
    private Member getLoginMember(String id) {
    	for(Member m : members) {
    		if(m.id.equals(id)) {
    			return m;
    		}
    	}
    	return null;
    }
    
        
    
}
