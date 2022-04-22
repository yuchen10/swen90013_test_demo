package com.jerry.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-04-15 18:02:01
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}


