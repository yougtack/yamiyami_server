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
    MemberController m = new MemberController();
    Integer ErrorNo = 0;

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
    public Integer insertComment(@RequestBody CommentModel comment, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            System.out.println("로그인하지 않고 댓글입력해서 입력이안됌.");
            ErrorNo = 403;
            return ErrorNo;
        }
        return commentService.insertComment(comment.getSid(), comment.getUserId(), comment.getComment());
    }

    //댓글 수정하기
    @RequestMapping(method = RequestMethod.PUT)
    public Integer updateComment(@RequestBody CommentModel comment, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            System.out.println("로그인하지 않고 댓글수정 수정이안됌.");
            ErrorNo = 403;
            return ErrorNo;
        }

        MemberModel member = (MemberModel)session.getAttribute("member");
        if(member.getUserId() == comment.getUserId()){
            return commentService.updateComment(comment.getCid(), comment.getComment());
        }
        ErrorNo = 200;
        return ErrorNo;
    }

    //댓글 삭제하기
    @RequestMapping(value = "/{cid}", method = RequestMethod.DELETE)
    public Integer deleteComment(@PathVariable Integer cid, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            ErrorNo = 403;
            System.out.println("로그인하지 않고 댓글삭제해서 삭제이안됌.");
            return ErrorNo;
        }
        MemberModel member = (MemberModel)session.getAttribute("member");
        CommentModel cm = commentService.getCid(cid);

        if(member.getUserId() == cm.getUserId()){
            return commentService.deleteComment(cid);
        }
        ErrorNo = 200;
        return ErrorNo;
    }

    //내가 쓴 댓글
    @RequestMapping(value = "/myComment/{userNo}", method = RequestMethod.GET)
    public List<CommentModel> myComment(@PathVariable Integer userNo, HttpSession session){
        if(m.loginCheck((MemberModel)session.getAttribute("member")) == 403){
            System.out.println("로그인하지 않고 내가 쓴 댓글 확일할려해서 안됌.");
            return null;
        }
        List<CommentModel> myComment = commentService.myComments(userNo);
        return myComment;
    }
}