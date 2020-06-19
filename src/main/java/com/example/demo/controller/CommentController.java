package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/comments")
public class CommentController {
    @Autowired
    CommentService commentService;


    //댓글 보여주기
//    @RequestMapping(value="/comment/{sid}", method = RequestMethod.GET)
//    public CommentModel showComment(@PathVariable Integer sid){
//        CommentModel result = commentService.showComment(sid);
//        return result;
//    }

    //댓글 입력하기
    @RequestMapping(value="/comment", method = RequestMethod.POST)
    public Integer insertComment(@RequestBody CommentModel comment){
        return commentService.insertComment(comment.getSid(), comment.getUserNo(), comment.getComment());
    }

    //댓글 수정하기
//    @RequestMapping(value="/comment", method = RequestMethod.PUT)
//    public CommentModel updateComment(@RequestBody CommentModel comment){
//        CommentModel result = commentService.updateComment(comment.getSid(), comment.getUserNo(), comment.getComment() );
//        return result;
//    }

    //댓글 삭제하기
    @RequestMapping(value="/comment/{cid}", method = RequestMethod.DELETE)
    public Integer deleteComment(@PathVariable Integer cid){
        return commentService.deleteComment(cid);
    }


}