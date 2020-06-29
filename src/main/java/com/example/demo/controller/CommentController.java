package com.example.demo.controller;

import com.example.demo.model.CommentModel;
import com.example.demo.model.MemberModel;
import com.example.demo.service.CommentService;
import com.example.demo.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value="/comments")
public class CommentController {
    MemberController m = new MemberController();

    @Autowired
    CommentService commentService;


    //댓글 보여주기
    @RequestMapping(value="/{sid}", method = RequestMethod.GET)
    public List<CommentModel> showComments(@PathVariable("sid") Integer sid){
        List<CommentModel> result = commentService.showComments(sid);
        return result;
    }

    //댓글 입력하기
    @RequestMapping(method = RequestMethod.POST)
    public Integer insertComment(@RequestBody CommentModel comment, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        Integer insertComment = null;
        if(loginUserId != null){
            insertComment = commentService.insertComment(comment.getSid(), comment.getUserId(), comment.getComment());
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return insertComment;
    }

    //댓글 수정하기
    @RequestMapping(method = RequestMethod.PUT)
    public Integer updateComment(@RequestBody CommentModel comment, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        Integer updateComment = null;
        if(loginUserId != null){
            updateComment = commentService.updateComment(comment.getCid(), comment.getComment());
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return updateComment;
    }

    //댓글 삭제하기
    @RequestMapping(value = "/{cid}", method = RequestMethod.DELETE)
    public Integer deleteComment(@PathVariable Integer cid, HttpServletRequest request, HttpServletResponse response) {
        String loginUserId = LoginUtil.getLoginUserId(request);

        //그 댓글의 유저아이디와 현재 내 유저아이디가 같으면 삭제되게

        Integer deleteComment = null;
        if(loginUserId != null){
            deleteComment = commentService.deleteComment(cid);
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return deleteComment;
    }

    //내가 쓴 댓글
    @RequestMapping(value = "/myComment/{userId}", method = RequestMethod.GET)
    public List<CommentModel> myComment(@PathVariable String userId, HttpServletRequest request, HttpServletResponse response){
        String loginUserId = LoginUtil.getLoginUserId(request);

        List<CommentModel> myComment = null;
        if(loginUserId != null){
           myComment = commentService.myComments(userId);
        }
        else{
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
        return myComment;
    }
}