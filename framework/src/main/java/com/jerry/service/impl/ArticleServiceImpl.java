package com.jerry.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Article;
import com.jerry.domain.entity.Category;
import com.jerry.domain.vo.ArticleDetailVo;
import com.jerry.domain.vo.ArticleListVo;
import com.jerry.domain.vo.HotArticleVo;
import com.jerry.domain.vo.PageVo;
import com.jerry.mapper.ArticleMapper;
import com.jerry.service.ArticleService;
import com.jerry.service.CategoryService;
import com.jerry.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 文章表(Article)表服务实现类
 *
 * @author makejava
 * @since 2022-04-12 16:23:27
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseResult hotArticleList() {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getStatus, 0);
        wrapper.orderByDesc(Article::getViewCount);
        Page<Article> page = new Page<>(1, 10);
        page(page, wrapper);
        List<Article> list = page.getRecords();
        List<HotArticleVo> articles = BeanCopyUtils.copyBeanList(list, HotArticleVo.class);

        return ResponseResult.okResult(articles);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        Page<Article> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        wrapper.eq(Article::getStatus, 0);
        wrapper.orderByDesc(Article::getIsTop);
        Page<Article> articlePage = page(page, wrapper);

        //查询分类名称
        List<Article> records = page.getRecords();
        //用articleId查询categoryName
        List<Article> infos = page.getRecords()
                .stream()
                .map(record -> {
                    return record.setCategoryName(categoryService.getById(record.getCategoryId()).getName());
                })
                .collect(Collectors.toList());

        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(infos, ArticleListVo.class);
        PageVo pageVo = new PageVo(articleListVos, page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        Article article = getById(id);
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        return ResponseResult.okResult(articleDetailVo);
    }

}
