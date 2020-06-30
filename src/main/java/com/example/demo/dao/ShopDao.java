package com.example.demo.dao;

import com.example.demo.model.CategoriesModel;
import com.example.demo.model.GoodModel;
import com.example.demo.model.ShopModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    Integer insertShop(
            @Param("name") String name,
            @Param("tel") String tel, @Param("addr") String addr,
            @Param("openTime") String openTime, @Param("closeTime") String closeTime,
            @Param("categoryId") Integer categoryId, @Param("userId") String userId
    );

    Integer insertProduct(@Param("product") String product, @Param("cost") Integer cost);

    Integer insertInShopProduct(@Param("sid") Integer sid, @Param("productName") String productName, @Param("cost") Integer cost);

    List<ShopModel> category(@Param("categoryId") Integer categoryId);

    List<GoodModel> getGoodList(@Param("sid") Integer sid);

    List<ShopModel> shopRanking();

    ShopModel shopView(@Param("sid") Integer sid);

    GoodModel getGood(@Param("sid") Integer sid, @Param("userId") String userId);

    Integer firstShopGood(@Param("sid") Integer sid, @Param("userId") String userId);

    Integer shopGood(@Param("sid") Integer sid, @Param("userId") String userId, @Param("good") Integer good);

    List<ShopModel> searchWord(@Param("word") String word);

    List<ShopModel> myShop(@Param("userId") String userId);

    Integer deleteMyShop(@Param("sid") Integer sid);

    Integer updateMyShop(
            @Param("sid") Integer sid, @Param("name") String name,
            @Param("tel") String tel, @Param("addr") String addr,
            @Param("openTime") String openTime, @Param("closeTime") String closeTime,
            @Param("categoryId") Integer categoryId
    );
}