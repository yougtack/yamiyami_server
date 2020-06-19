package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

public interface CommentDao {
    Integer insertComment(@Param("sid") Integer sid, @Param("userNo") Integer userNo, @Param("comment") String comment);

    Integer deleteComment(@Param("cid") Integer cid);
}