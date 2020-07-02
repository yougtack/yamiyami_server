package com.example.demo.service.serviceimpl;


import com.example.demo.dao.MemberDao;
import com.example.demo.model.MemberModel;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

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

    //NAVER트랜잭션이 있을때 오류 발생시킴
    //MANDATORY 트랜잭션이 없을때 오류 발생
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void testTransaction(){
        System.out.println("in memberService: "+TransactionSynchronizationManager.getCurrentTransactionName());
    }
}