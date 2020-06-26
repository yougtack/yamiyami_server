package com.example.demo.dao;

import com.example.demo.model.CommentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    Integer insertComment(@Param("sid") Integer sid, @Param("userId") String userId, @Param("comment") String comment);

    Integer deleteComment(@Param("cid") Integer cid);

    Integer updateComment(@Param("cid") Integer cid, @Param("comment") String comment);

    List<CommentModel> showComments(@Param("sid") Integer sid);

    List<CommentModel> myComments(@Param("userNo") Integer userNo);
}