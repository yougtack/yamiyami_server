package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/main")
public class ShopController {
    MemberController m = new MemberController();
    Integer ErrorNo = 0;

    @Autowired
    ShopService shopService;


    @Autowired
    CategoriesService categoriesService;

    //인덱스페이지 이동
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public void IndexPage(@RequestHeader(value = "user-Agent") String userAgent, HttpSession session){
        System.out.println(userAgent);
        //틀리면 -1이하
        //맞으면 0이상
//        if(userAgent.indexOf("PostmanRuntime/7.26.1") > -1){ //iPhone으로 하고싶을때

        if(userAgent.indexOf("iPhone") > -1){ //그냥 안드로이드
            System.out.println("yamiyamiApp입니다.// 사실 포스트빵구임");
            session.setAttribute("userAgent", "iPhone");
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
    public Integer insertShop(@RequestBody ShopModel shop, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            ErrorNo = 403;
            System.out.println("로그인하지 않고 가게입력해서 입력이안됌.");
            return ErrorNo;
        }

        shopService.insertShop(shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpenTime(), shop.getCloseTime(), shop.getCategoryId(), shop.getUserId());
        return shopService.insertProduct(shop.getPname(), shop.getCost());
    }

    //내가쓴 맛집
    @RequestMapping(value = "/myShop/{userId}", method = RequestMethod.GET)
    public List<ShopModel> myShop(@PathVariable String userId, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            System.out.println("로그인안하면 내가쓴 맛집 못봄");
            return null;
        }
        List<ShopModel> myShop = shopService.myShop(userId);
        return myShop;
    }

    //내가쓴 맛집 삭제
    @RequestMapping(value = "/myShop/{sid}", method = RequestMethod.DELETE)
    public Integer deleteMyShop(@PathVariable Integer sid, HttpSession session){
        //에이전트 구분한다 쳐보자
        //이부분이 web
            if(m.loginCheck((MemberModel) session.getAttribute("member")) == 403) {
                ErrorNo = 403;
                System.out.println("로그인안하면 내가쓴 맛집 삭제안됌");
                return ErrorNo;
            }
        //이부분이 app
        //만약 앱이라면 다른처리를 해야할까?
        return shopService.deleteMyShop(sid);
    }

    //내가쓴 맛집 수정
    @RequestMapping(value = "/myShop", method = RequestMethod.PUT)
    public Integer updateMyShop(@RequestBody ShopModel shop, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            ErrorNo = 403;
            System.out.println("로그인안하면 내가쓴 맛집 수정안됌");
            return ErrorNo;
        }
        return shopService.updateMyShop(shop.getSid(), shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpenTime(), shop.getCloseTime(), shop.getCategoryId());
    }
}