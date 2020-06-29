package com.example.demo.util;

import org.springframework.http.HttpHeaders;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginUtil {

    public static final String AGENT_NAME = "yami"; //상수로 agent_name을 선

    public static boolean isApp( HttpServletRequest request ) {
        String userAgent = request.getHeader(HttpHeaders.USER_AGENT );
        boolean isApp = userAgent.indexOf(AGENT_NAME) >= 0; //포함되어 있으면 참짓, 포함되어 있지 않으면 거
        return userAgent.indexOf(AGENT_NAME) >= 0; //포함되어 있으면 참짓, 포함되어 있지 않으면 거
    }

    public static String getAuthorization( HttpServletRequest request ) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        return authorization;
    }

    public static String getCookieUserId( HttpServletRequest request ) {

        Cookie[] cookies = request.getCookies();
        String cookieValue = null;

        if(cookies != null){
            for(int i=0; i<cookies.length; i++){
                if(i==0){
                    cookieValue=null;
                }else{
                    cookieValue = cookies[i].getValue();
                }
;            }
        }

        return cookieValue;
    }

    public static String getLoginUserId( HttpServletRequest request ) {
        String userId = null;
        boolean app = isApp(request);  //웹이면 false
        if ( app ) {
            userId = getAuthorization(request);
        }
        else {
            userId = getCookieUserId(request);
        }
        return userId;
    }

}
