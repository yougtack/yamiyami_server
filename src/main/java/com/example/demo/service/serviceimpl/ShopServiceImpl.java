package com.example.demo.service.serviceimpl;

import com.example.demo.dao.ShopDao;
import com.example.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao dao;

    @Override
    public Integer insertShop(String name, String tel, String addr, String open_time, String end_time, String foodType, String userId){
        return dao.insertShop(name, tel, addr, open_time, end_time, foodType, userId);
    }

}

