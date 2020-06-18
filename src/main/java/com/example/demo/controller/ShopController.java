package com.example.demo.controller;


import com.example.demo.model.CategoriesModel;
import com.example.demo.service.CategoriesService;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public List<CategoriesModel> getList(){
        List<CategoriesModel> CategoriesList = categoriesService.CategoriesList();
        return CategoriesList;
    }

    //아직 미완성
    //가게추가
    @RequestMapping(value = "/insertShop/{name}/{tel}/{addr}/{open_time}/{end_time}/{foodType}/{userId}", method = RequestMethod.POST)
    public Integer insertShop(@PathVariable String name, @PathVariable String tel, @PathVariable String addr,
                              @PathVariable String open_time, @PathVariable String end_time, @PathVariable String foodType,
                              @PathVariable String userId
                            ){

        return shopService.insertShop(name, tel, addr, open_time, end_time, foodType, userId);
    }
}
