package com.example.demo.service;

import com.example.demo.model.GoodModel;
import com.example.demo.model.ShopInsertModel;
import com.example.demo.model.ShopModel;

import java.util.List;

public interface ShopService {

    //가게추가
    Integer insertShop (String name, String tel, String addr, String openTime, String closeTime, Integer categoryId, String userId);
    Integer insertProduct(String[] pname, Integer[] cost);

    //가게안에서 상품추가
    Integer insertInShopProduct(Integer sid, String[] pname, Integer[] cost);

    //음식 종류별
    List<ShopModel> category(Integer category);

    //좋아요 정보
    List<GoodModel> getGoodList(Integer sid);

    //가게랭크
    List<ShopModel> shopRanking();

    //가게 상세정보
    ShopModel shopView(Integer sid);

    //가게추천 테이블 정보 가져오기
    GoodModel getGood(Integer sid, String userId);

    //가게 추천 처음일때
    Integer firstShopGood(Integer sid, String userId);

    //가게 추천 & 취소
    Integer shopGood(Integer sid, String userId, Integer good);

    //단어검색
    List<ShopModel> searchWord(String word);

    //내가 입력한 가게 보기
    List<ShopModel> myShop(String userId);

    //내가 입력한 가게 삭제하기
    Integer deleteMyShop(Integer sid);

    //내가 입력한 가게 수정하기
    Integer updateMyShop(Integer sid, String name, String tel, String addr, String openTime, String closeTime, Integer categoryId);

}