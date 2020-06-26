package com.example.demo.controller;


import com.example.demo.model.MemberModel;
import com.example.demo.service.MemberService;
import com.example.demo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    //로그인
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public MemberModel Login(@RequestBody MemberModel member, HttpServletRequest request, HttpServletResponse response){

        MemberModel userInfo = memberService.login(member.getUserId(), member.getUserPw());
        boolean isApp = LoginUtil.isApp( request ); //앱인지 웹인지 구분함, 웹이면 false뜸
        if ( userInfo != null ) { //만약 DB에서 가져온 값이 null이 아니라면
            if ( !isApp ) { //웹일때
                Cookie cookie = new Cookie("userId", userInfo.getUserId()); //userId라는 이름으로 쿠키생성
                cookie.setMaxAge(-1);
                cookie.setPath("/");

                response.addCookie(cookie); //쿠키응답
            }
        }
        else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }

        return userInfo;
    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("userId","123"); //userId라는 이름으로 쿠키생성
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        return "로그아웃 완료";
    }

    //회원가입
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public Integer SignUp(@RequestBody MemberModel member){
        return memberService.insertMember(member.getUserId(), member.getUserPw());
    }
}
