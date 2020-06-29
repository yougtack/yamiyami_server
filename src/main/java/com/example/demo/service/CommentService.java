package com.example.demo.service;


import com.example.demo.model.CommentModel;

import java.util.List;

public interface CommentService {
    Integer insertComment(Integer sid, String userId, String comment);

    Integer deleteComment(Integer cid);

    Integer updateComment(Integer cid, String comment);

    List<CommentModel> showComments(Integer sid);

    List<CommentModel> myComments(String userId);
}