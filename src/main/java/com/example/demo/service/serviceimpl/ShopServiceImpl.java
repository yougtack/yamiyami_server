package com.example.demo.service.serviceimpl;

import com.example.demo.dao.ShopDao;
import com.example.demo.model.GoodModel;
import com.example.demo.model.ShopModel;
import com.example.demo.service.MemberService;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao dao;

    @Autowired
    MemberService memberService;

    @Override
    @Transactional
    public Integer insertShop(String name, String tel, String addr, String openTime, String closeTime, Integer categoryId, String userId){
//        System.out.println("in shopService: "+TransactionSynchronizationManager.getCurrentTransactionName());
//        memberService.testTransaction();
        return dao.insertShop(name, tel, addr, openTime, closeTime, categoryId, userId);
    }

    @Override
    @Transactional
    public Integer insertProduct(String[] pname, Integer[] cost){
        Integer result = 0;
        Integer i = 0;
        try{
            for (String product:pname) {
                result += dao.insertProduct(product, cost[i]);
                ++i;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            i=0;
        }
        return result;
    }

    @Override
    @Transactional
    public Integer insertInShopProduct(Integer sid, String[] pname, Integer[] cost){
        Integer result = 0;
        Integer i = 0;
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        try{
            for (String productName:pname) {
                result +=  dao.insertInShopProduct(sid, productName, cost[i]);
                ++i;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            i=0;
        }
        return result;
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

    @Override
    public Integer image(String image){
        return dao.image(image);
    }
}