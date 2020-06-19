package com.example.demo.dao;

import com.example.demo.model.ProductModel;
import com.example.demo.model.ShopModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    Integer insertShop(
            @Param("name") String name,
            @Param("tel") String tel, @Param("addr") String addr,
            @Param("open_time") String open_time, @Param("end_time") String end_time,
            @Param("categoryId") Integer categoryId, @Param("userId") String userId
    );

    Integer insertProduct(@Param("pname") String pname, @Param("cost") String cost);

    List<ShopModel> category(@Param("categoryId") Integer categoryId);

    ShopModel shopView(@Param("sid") Integer sid);


    List<ProductModel> productView(@Param("sid") Integer sid);

    List<ShopModel> myShop(@Param("userId") String userId);

    Integer deleteMyShop(@Param("sid") Integer sid);

    Integer updateMyShop(
            @Param("sid") Integer sid, @Param("name") String name,
            @Param("tel") String tel, @Param("addr") String addr,
            @Param("open_time") String open_time, @Param("end_time") String end_time,
            @Param("categoryId") Integer categoryId
    );
}