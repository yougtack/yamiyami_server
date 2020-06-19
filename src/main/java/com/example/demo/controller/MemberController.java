package com.example.demo.controller;


import com.example.demo.model.MemberModel;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    //로그인
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public MemberModel Login(@RequestBody MemberModel member, HttpSession session){
        MemberModel userInfo = memberService.login(member.getUserId(), member.getUserPw());
        session.setAttribute("member", userInfo);

        return userInfo;
    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "로그아웃 완료";
    }

    //회원가입
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Integer SignUp(@RequestBody MemberModel member){
        return memberService.insertMember(member.getUserId(), member.getUserPw());
    }
}
