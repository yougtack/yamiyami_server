package com.example.demo.service.serviceimpl;


import com.example.demo.dao.MemberDao;
import com.example.demo.model.MemberModel;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;


    @Override
    public int insertMember(String userId, String userPw){
        return dao.insertMember(userId, userPw);
    }

    @Override
    public MemberModel login(String userId, String userPw){
        return dao.login(userId, userPw);
    }
}