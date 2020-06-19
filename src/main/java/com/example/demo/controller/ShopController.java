package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/main")
public class ShopController {

    @Autowired
    ShopService shopService;

    @Autowired
    CategoriesService categoriesService;

    //인덱스페이지 이동
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView IndexPage(){
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }

    //카테고리 리스트 가져오기
    @RequestMapping(value ="/categories", method = RequestMethod.GET)
    public List<CategoriesModel> getList(Model model){
        List<CategoriesModel> CategoriesList = categoriesService.CategoriesList();
        model.addAttribute("categories", CategoriesList);
        return CategoriesList;
    }

    //음식종류별로 리스트뽑기
    @RequestMapping(value="/category/{categoryId}", method = RequestMethod.GET)
    public List<ShopModel> Category(@PathVariable Integer categoryId, Model model){
       List<ShopModel> category = shopService.category(categoryId);
       model.addAttribute("category", category);
        return category;
    }

    //가게 상세정보
    @RequestMapping(value="/shop/{sid}", method = RequestMethod.GET)
    public ShopModel viewShop(@PathVariable Integer sid, Model model) {
        ShopModel shopView = shopService.shopView(sid);
        model.addAttribute("shop",shopView);

        List<ProductModel> product = shopService.productView(sid);
        model.addAttribute("product", product);
        return shopView;
    }

    //맛집추가
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public Integer insertShop(@RequestBody ShopModel shop, @RequestBody ProductModel product){
        shopService.insertProduct(product.getPname(), product.getCost());
        return shopService.insertShop(shop.getName(), shop.getTel(), shop.getAddr(), shop.getOpen_time(), shop.getEnd_time(), shop.getCategoryId(), shop.getUserId());
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