package com.example.demo.service.serviceimpl;


import com.example.demo.dao.CommentDao;
import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao dao;


    @Override
    public Integer insertComment(Integer sid, String userId, String comment){
        return dao.insertComment(sid, userId, comment);
    }

    @Override
    public Integer deleteComment(Integer cid){
        return dao.deleteComment(cid);
    }

    @Override
    public Integer updateComment(Integer cid, String comment){
        return dao.updateComment(cid, comment);
    }

    @Override
    public List<CommentModel> showComments(Integer sid){
        return dao.showComments(sid);
    }

    @Override
    public List<CommentModel> myComments(String userId){
        return dao.myComments(userId);
    }

}