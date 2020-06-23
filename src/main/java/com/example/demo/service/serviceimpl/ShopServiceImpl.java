package com.example.demo.service.serviceimpl;

import com.example.demo.dao.ShopDao;
import com.example.demo.model.ProductModel;
import com.example.demo.model.ShopModel;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao dao;

    @Override
    public Integer insertShop(String name, String tel, String addr, String openTime, String closeTime, Integer categoryId, String userId){
        return dao.insertShop(name, tel, addr, openTime, closeTime, categoryId, userId);
    }

    @Override
    public Integer insertProduct(String pname, Integer cost){
        return dao.insertProduct(pname, cost);
    }
    @Override
    public List<ShopModel> category(Integer categoryId){
        return dao.category(categoryId);
    }

    @Override
    public ShopModel shopView(Integer sid){
        return dao.shopView(sid);
    }

    @Override
    public List<ShopModel> myShop(String userId){
        return dao.myShop(userId);
    }

    @Override
    public Integer deleteMyShop(Integer sid){
        return dao.deleteMyShop(sid);
    }

    @Override
    public Integer updateMyShop(Integer sid, String name, String tel, String addr, String openTime, String closeTime, Integer categoryId){
        return dao.updateMyShop(sid, name, tel, addr, openTime, closeTime, categoryId);
    }
}