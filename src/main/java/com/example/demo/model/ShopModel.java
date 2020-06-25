package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ShopModel {
    private int sid;
    private String file;
    private String name;
    private String tel;
    private String addr;
    private String openTime;
    private String closeTime;
    private int categoryId;
    private String userId;

    private List<ProductModel> products;
    private List<CommentModel> comments;
}