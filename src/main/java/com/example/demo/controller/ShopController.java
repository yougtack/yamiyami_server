package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ShopService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        System.out.println(userAgent.indexOf("Chrome"));
        System.out.println(userAgent.indexOf("CriOS"));
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
    public List<ShopModel> viewShop(@PathVariable Integer sid) {
//        ShopModel shopModel = new ShopModel();
//        shopModel.setSid(6);
//        shopModel.setName("슈퍼집");
//        shopModel.setTel("02-540-1591");
//        shopModel.setAddr("서울특별시 강남구 논현동 246-1");
//        shopModel.setOpen_time("11:30");
//        shopModel.setEnd_time("01:00");
//        shopModel.setCategoryId(2);
//        shopModel.setUserId("asd");
//
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("pname","마늘 떡볶이");
//        map.put("cost",9000);
//        shopModel.setMap(map);
//
//
//        System.out.println("model:"+shopModel.getSid());
//        System.out.println("model:"+shopModel.getName());
//        System.out.println("model:"+shopModel.getTel());
//        System.out.println("model:"+shopModel.getAddr());
//        System.out.println("model:"+shopModel.getOpen_time());
//        System.out.println("model:"+shopModel.getEnd_time());
//        System.out.println("model:"+shopModel.getCategoryId());
//        System.out.println("model:"+shopModel.getUserId());
//        System.out.println("model:"+shopModel.getMap());
//
        List<ShopModel> shopView = shopService.shopView(sid);
        sqlSession.selectList("getProduct", shopView);
        return shopView;

    }

    //맛집추가
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public Integer insertShop(@RequestBody ShopModel shop){
        return shopService.insertShop(shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpen_time(), shop.getEnd_time(), shop.getCategoryId(), shop.getUserId(), shop.getPname(), shop.getCost());
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
        return shopService.updateMyShop(shop.getSid(), shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpen_time(), shop.getEnd_time(), shop.getCategoryId());
    }
}