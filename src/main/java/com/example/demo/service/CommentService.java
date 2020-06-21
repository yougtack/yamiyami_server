package com.example.demo.service;


import com.example.demo.model.CommentModel;

import java.util.List;

public interface CommentService {
    Integer insertComment(Integer sid, Integer userNo, String comment);

    Integer deleteComment(Integer cid);

    CommentModel getCid(Integer cid);

    Integer updateComment(Integer cid, String comment);

    List<CommentModel> showComments(Integer sid);

    List<CommentModel> myComments(Integer userNo);
}