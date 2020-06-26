package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchWordModel {
    private int sid;
    private String file;
    private String name;
    private String tel;
    private String addr;
    private String openTime;
    private String closeTime;
    private Integer total_good = 0;
}
