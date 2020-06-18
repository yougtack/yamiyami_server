package com.example.demo.service;

import com.example.demo.model.MemberModel;

public interface MemberService {

    int insertMember(String userId, String userPw);

    MemberModel login(String userId, String userPw);
}
