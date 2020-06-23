package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriesModel {
    private String categoryId;
    private String categoryName;
    private String image;

    private List<ShopModel> shops;
}