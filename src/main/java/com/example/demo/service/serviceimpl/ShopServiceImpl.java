package com.example.demo.service.serviceimpl;

import com.example.demo.dao.ShopDao;
import com.example.demo.model.GoodModel;
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
    public Integer insertInShopProduct(Integer sid, String pname, Integer cost){
        return dao.insertInShopProduct(sid, pname, cost);
    }


    @Override
    public List<GoodModel> getGoodList(Integer sid){
        return dao.getGoodList(sid);
    }

    @Override
    public List<ShopModel> category(Integer categoryId){
        return dao.category(categoryId);
    }

    @Override
    public List<ShopModel> shopRanking(){
        return dao.shopRanking();
    }

    @Override
    public ShopModel shopView(Integer sid){
        return dao.shopView(sid);
    }

    @Override
    public GoodModel getGood(Integer sid, String userId){
        return dao.getGood(sid, userId);
    }

    @Override
    public Integer firstShopGood(Integer sid, String userId){
        return dao.firstShopGood(sid, userId);
    }

    @Override
    public Integer shopGood(Integer sid, String userId, Integer good){
        return dao.shopGood(sid, userId, good);
    }


    @Override
    public List<ShopModel> searchWord(String word){
        return dao.searchWord(word);
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