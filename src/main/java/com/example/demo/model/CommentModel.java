package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CommentModel {
    private Integer sid;
    private Integer cid;
    private String userId;
    private String comment;
}