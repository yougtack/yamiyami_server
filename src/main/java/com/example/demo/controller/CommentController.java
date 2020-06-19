package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.model.MemberModel;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value="/comments")
public class CommentController {
    @Autowired
    CommentService commentService;


    //댓글 보여주기
    @RequestMapping(value="/{sid}", method = RequestMethod.GET)
    public List<CommentModel> showComments(@PathVariable Integer sid){
        List<CommentModel> result = commentService.showComments(sid);
        return result;
    }

    //댓글 입력하기
    @RequestMapping(method = RequestMethod.POST)
    public Integer insertComment(@RequestBody CommentModel comment){
        return commentService.insertComment(comment.getSid(), comment.getUserNo(), comment.getComment());
    }

    //댓글 수정하기
    @RequestMapping(method = RequestMethod.PUT)
    public Integer updateComment(@RequestBody CommentModel comment, HttpSession session){
        MemberModel member = (MemberModel)session.getAttribute("member");

        int commentNo = comment.getUserNo();
        int memberNo = Integer.parseInt(member.getUserNo());

        if(memberNo == commentNo){
            return commentService.updateComment(comment.getCid(), comment.getComment());
        }
        return 0;
    }

    //댓글 삭제하기
    @RequestMapping(value = "/{cid}", method = RequestMethod.DELETE)
    public Integer deleteComment(@PathVariable Integer cid, HttpSession session){
        MemberModel member = (MemberModel)session.getAttribute("member");
        CommentModel cm = commentService.getCid(cid);

        int commentNo = cm.getUserNo();
        int memberNo = Integer.parseInt(member.getUserNo());

        if(memberNo == commentNo){
            return commentService.deleteComment(cid);
        }
        return 0;
    }

    //내가 쓴 댓글
    @RequestMapping(value = "/myComment/{userNo}", method = RequestMethod.GET)
    public List<CommentModel> myComment(@PathVariable Integer userNo){
        List<CommentModel> myComment = commentService.myComments(userNo);
        return myComment;
    }
}