package com.jerry.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Article;

/**
 * 文章表(Article)表服务接口
 *
 * @author makejava
 * @since 2022-04-12 12:12:09
 */
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}


