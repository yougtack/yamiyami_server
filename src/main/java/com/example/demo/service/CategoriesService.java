package com.example.demo.service;

import com.example.demo.model.CategoriesModel;

import java.util.List;

public interface CategoriesService {
    List<CategoriesModel> CategoriesList();

    List<CategoriesModel> insertCategories();
}