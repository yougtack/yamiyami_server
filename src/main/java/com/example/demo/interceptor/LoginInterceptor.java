//package com.example.demo.interceptor;
//
//import com.example.demo.model.MemberModel;
//import com.example.demo.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//
//    @Autowired
//    MemberService memberService;
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
//        System.out.println(handler.toString()+"가 종료되었습니다. ");
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
//        System.out.println(handler.toString() + "를 호출했습니다.");
//
//        Cookie[] cookies = request.getCookies();
////        Integer i = 0;
//
//        if(cookies != null) {
//            for(Cookie cookie : cookies) {
//                if("memberNo".equals(cookie.getName())) {
////                    i = Integer.parseInt(cookie.getValue());
//                    System.out.println("interceptor//cookieName:"+cookie.getName()+" cookieValue:"+cookie.getValue());
//                }
//            }
//        }
////        System.out.println("i:"+i);
////        MemberModel member = memberService.getMember(i);
////        if(member == null){
////            return false;
////        }
//        return true;
//    }
//}
