package com.example.demo.service;

import com.example.demo.model.ProductModel;
import com.example.demo.model.ShopModel;

import java.util.List;

public interface ShopService {

    //가게추가
    Integer insertShop (String name, String tel, String addr, String open_time, String end_time, Integer categoryId, String userId);

    Integer insertProduct(String pname, Integer cost);
    //음식 종류별
    List<ShopModel> category(Integer category);

    //가게 상세정보
    ShopModel shopView(Integer sid);

    //내가 입력한 가게 보기
    List<ShopModel> myShop(String userId);

    //내가 입력한 가게 삭제하기
    Integer deleteMyShop(Integer sid);

    //내가 입력한 가게 수정하기
    Integer updateMyShop(Integer sid, String name, String tel, String addr, String open_time, String end_time, Integer categoryId);

}