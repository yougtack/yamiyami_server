package com.example.demo.service.serviceimpl;


import com.example.demo.dao.CommentDao;
import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao dao;


    @Override
    public Integer insertComment(Integer sid, Integer userNo, String comment){
        return dao.insertComment(sid, userNo, comment);
    }

    @Override
    public Integer deleteComment(Integer cid){
        return dao.deleteComment(cid);
    }

}