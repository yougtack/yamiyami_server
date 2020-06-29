package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyCommentModel {
    private String name;
    private Integer sid;
    private Integer cid;
    private String userId;
    private String comment;
}