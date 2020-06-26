package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ShopService;
import com.example.demo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/main")
public class ShopController {
    @Autowired
    ShopService shopService;

    @Autowired
    CategoriesService categoriesService;

    //카테고리 리스트 가져오기
    @RequestMapping(value ="/categories", method = RequestMethod.GET)
    public List<CategoriesModel> getList(){
        List<CategoriesModel> categoriesList = categoriesService.CategoriesList();
        return categoriesList;
    }

    //카테고리 리스트 랭킹빼고 가져오
    @RequestMapping(value ="/rmRanking", method = RequestMethod.GET)
    public List<CategoriesModel> getUnRankingList(){
        List<CategoriesModel> rmRankingList = categoriesService.getRmRankingList();
        return rmRankingList;
    }


    //음식종류별로 리스트뽑기
    @RequestMapping(value="/category/{categoryId}", method = RequestMethod.GET)
    public List<ShopModel> Category(@PathVariable("categoryId") Integer categoryId){

        List<ShopModel> shopRanking = null;
        List<ShopModel> category = null;
        if(categoryId == 13){
           shopRanking = shopService.shopRanking();
           return shopRanking;
        }
        category = shopService.category(categoryId);
        return category;
    }

    //가게 상세정보
    @RequestMapping(value="/shop/{sid}", method = RequestMethod.GET)
    public ShopModel viewShop(@PathVariable("sid") Integer sid) {
        ShopModel shopView = shopService.shopView(sid);
        return shopView;
    }

    //가게 추천
    @RequestMapping(value = "/shop/good", method = RequestMethod.POST)
    public Integer shopGood(@RequestBody GoodModel good, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        Integer shopGood = null;
        GoodModel getGood = shopService.getGood(good.getSid(), good.getUserId());
        if(loginUserId != null){
            if(getGood != null){
                shopGood = shopService.shopGood(good.getSid(), good.getUserId(), getGood.getGood());
            }
            else{
                shopGood = shopService.firstShopGood(good.getSid(), good.getUserId());
            }
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return shopGood;
    }

    //단어 검색
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<ShopModel> search(@RequestParam("word") String word){
        List<ShopModel>  searchList = shopService.searchWord(word);
        return searchList;
    }
    //맛집추가
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public Integer insertShop(@RequestBody ShopInsertModel shop, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        Integer insertShop = null;
        if(loginUserId != null){
            shopService.insertShop(shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpenTime(), shop.getCloseTime(), shop.getCategoryId(), shop.getUserId());
            insertShop = shopService.insertProduct(shop.getPname(), shop.getCost());
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return insertShop;
    }

    //내가쓴 맛집
    @RequestMapping(value = "/myShop", method = RequestMethod.GET)
    public List<ShopModel> myShop(HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        List<ShopModel> myShop = null;
        if ( loginUserId != null ) { //비어 있지 않으면
            myShop = shopService.myShop(loginUserId);
        }
        else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return myShop;
    }

    //내가쓴 맛집 삭제
    @RequestMapping(value = "/myShop/{sid}", method = RequestMethod.DELETE)
    public Integer deleteMyShop(@PathVariable("sid") Integer sid, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request); //로그인이 되었는지 안되었는지 확인.. 로그인 되면 string 형태로 loginUserId에 들어감

        Integer deleteMyShop = null;
        if(loginUserId != null){
            deleteMyShop = shopService.deleteMyShop(sid);
        }else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return deleteMyShop;
    }

    //내가쓴 맛집 수정
    @RequestMapping(value = "/myShop", method = RequestMethod.PUT)
    public Integer updateMyShop(@RequestBody ShopModel shop, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        Integer updateMyShop = null;
        if(loginUserId != null){
            updateMyShop = shopService.updateMyShop(shop.getSid(), shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpenTime(), shop.getCloseTime(), shop.getCategoryId());
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return updateMyShop;
    }
}