package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

public interface ShopDao {
    Integer insertShop(
            @Param("name") String name,
            @Param("tel") String tel, @Param("addr") String addr,
            @Param("open_time") String open_time, @Param("end_time") String end_time,
            @Param("foodType") String foodType, @Param("userId") String userId
    );
}
