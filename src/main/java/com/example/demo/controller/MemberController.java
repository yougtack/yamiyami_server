package com.example.demo.controller;


import com.example.demo.model.MemberModel;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    //로그인
    @RequestMapping(value = "/login/{userId}/{userPw}", method = RequestMethod.GET)
    public MemberModel Login(@PathVariable String userId, @PathVariable String userPw, HttpSession session) {
        MemberModel userInfo = memberService.login(userId, userPw);
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
    @RequestMapping(value = "/signUp/{userId}/{userPw}", method = RequestMethod.POST)
    public Integer SignUp(@PathVariable String userId, @PathVariable String userPw) {
        return memberService.insertMember(userId, userPw);
    }
}
