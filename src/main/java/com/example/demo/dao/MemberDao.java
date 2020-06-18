package com.example.demo.dao;

import com.example.demo.model.MemberModel;
import org.apache.ibatis.annotations.Param;

public interface MemberDao {
    int insertMember(@Param("userId") String userId, @Param("userPw") String userPw);

    MemberModel login(@Param("userId") String userId, @Param("userPw") String userPw);
}
