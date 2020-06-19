package com.example.demo.service;

import com.example.demo.model.ProductModel;
import com.example.demo.model.ShopModel;

import java.util.List;

public interface ShopService {

    //가게추가
    Integer insertShop (String name, String tel, String addr, String open_time, String end_time, String categoryId, String userId);

    //상품추가
    Integer insertProduct(String pname, String cost);

    //음식 종류별
    List<ShopModel> category(Integer category);

    //가게 상세정보
    ShopModel shopView(Integer sid);

    //가게 상세정보_상품
    List<ProductModel> productView(Integer sid);
}