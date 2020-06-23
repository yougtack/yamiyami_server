package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ShopService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/main")
public class ShopController {

    @Autowired
    ShopService shopService;


    @Autowired
    CategoriesService categoriesService;

    @Autowired
    @Qualifier("sqlSession")
    private SqlSessionTemplate sqlSession;

    //인덱스페이지 이동
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public void IndexPage(@RequestHeader(value = "user-Agent") String userAgent){
        System.out.println(userAgent);

        //틀리면 1이하
        //맞으면 1이상
        //아니다. 0이
        if(userAgent.indexOf("yamiyamiApp") <= 0){
        }
    }

    //카테고리 리스트 가져오기
    @RequestMapping(value ="/categories", method = RequestMethod.GET)
    public List<CategoriesModel> getList(){
        List<CategoriesModel> categoriesList = categoriesService.CategoriesList();
        return categoriesList;
    }

    //음식종류별로 리스트뽑기
    @RequestMapping(value="/category/{categoryId}", method = RequestMethod.GET)
    public List<ShopModel> Category(@PathVariable Integer categoryId){
       List<ShopModel> category = shopService.category(categoryId);
        return category;
    }

    //가게 상세정보
    @RequestMapping(value="/shop/{sid}", method = RequestMethod.GET)
    public ShopModel viewShop(@PathVariable Integer sid) {
        ShopModel shopView = shopService.shopView(sid);
        return shopView;
    }

    //맛집추가
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public Integer insertShop(@RequestBody ShopModel shop){
        shopService.insertShop(shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpenTime(), shop.getCloseTime(), shop.getCategoryId(), shop.getUserId());
        return shopService.insertProduct(shop.getPname(), shop.getCost());
    }

    //내가쓴 맛집
    @RequestMapping(value = "/myShop/{userId}", method = RequestMethod.GET)
    public List<ShopModel> myShop(@PathVariable String userId){
        List<ShopModel> myShop = shopService.myShop(userId);
        return myShop;
    }

    //내가쓴 맛집 삭제
    @RequestMapping(value = "/myShop/{sid}", method = RequestMethod.DELETE)
    public Integer deleteMyShop(@PathVariable Integer sid){
        return shopService.deleteMyShop(sid);
    }

    //내가쓴 맛집 수정
    @RequestMapping(value = "/myShop", method = RequestMethod.PUT)
    public Integer updateMyShop(@RequestBody ShopModel shop){
        return shopService.updateMyShop(shop.getSid(), shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpenTime(), shop.getCloseTime(), shop.getCategoryId());
    }
}