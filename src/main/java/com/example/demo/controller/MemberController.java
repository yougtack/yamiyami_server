package com.example.demo.controller;


import com.example.demo.model.MemberModel;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/member")
public class MemberController {
    Integer memberNo = null;
    Integer ErrorNo = 0;

    public String userAgentCheck(HttpSession session){
        if(session.getAttribute("userAgent") == "iPhone"){
            return "app";
        }
        return "web";
    }

    public Integer loginCheck(MemberModel member){
        if( member == null){
            ErrorNo = 403;
            return ErrorNo;
        }
        ErrorNo = 200;
        return ErrorNo;
    }

    @Autowired
    MemberService memberService;

    //로그인
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public MemberModel Login(@RequestBody MemberModel member, HttpSession session){
        MemberModel userInfo = memberService.login(member.getUserId(), member.getUserPw());

        if(session.getAttribute("userAgent") == "iPhone"){
            if(userInfo != null){ //app에서 로그인실패하였을때 를 대비해서 만듬
                session.setAttribute("member", userInfo); //널포인트예외를 처리하기위해 app인데도 member에 값을 넣음
                this.memberNo = userInfo.getUserNo(); //app에서 사용될 userNo를 static userNo에 저장
            }
            System.out.println("static memberNo:"+memberNo);
        }else{
            session.setAttribute("member", userInfo);
            this.memberNo = -1;
        }
        return userInfo;
    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        if(this.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            System.out.println("로그인하지 않고 로그아웃을해서 진행되지않음");
            return null;
        }

        session.invalidate();
        memberNo = null;
        return "로그아웃 완료";
    }

    //회원가입
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Integer SignUp(@RequestBody MemberModel member){
        return memberService.insertMember(member.getUserId(), member.getUserPw());
    }
}
