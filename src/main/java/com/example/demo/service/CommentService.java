package com.example.demo.service;


import com.example.demo.model.CommentModel;

public interface CommentService {
    Integer insertComment(Integer sid, Integer userNo, String comment);

    Integer deleteComment(Integer cid);
}