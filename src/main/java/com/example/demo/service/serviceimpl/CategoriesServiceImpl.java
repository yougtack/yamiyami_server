package com.example.demo.service.serviceimpl;


import com.example.demo.dao.CategoriesDao;
import com.example.demo.model.CategoriesModel;
import com.example.demo.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesDao dao;

    @Override
    public List<CategoriesModel> CategoriesList(){
        return dao.CategoriesList();
    }

    @Override
    public List<CategoriesModel> getRmRankingList() {
        return dao.getRmRankingList();
    }
}