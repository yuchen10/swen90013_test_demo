package com.swen90013.controller;

import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Comment;
import com.jerry.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(articleId,pageNum,pageSize);
    }

    @PostMapping("/comment")
    public ResponseResult addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }
}