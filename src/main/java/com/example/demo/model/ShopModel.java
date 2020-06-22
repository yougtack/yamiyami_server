package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ShopModel {
    private int sid;
    private String file;
    private String name;
    private String tel;
    private String addr;
    private String open_time;
    private String end_time;
    private int categoryId;
    private String userId;

    private String pfile;
    private String pname;
    private int cost;
}