package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ShopCategoriesModel {
    private int sid;
    private String file;
    private String name;
    private String tel;
    private String addr;
    private String openTime;
    private String closeTime;
    private int categoryId;
    private int good;
    private String userId;
}