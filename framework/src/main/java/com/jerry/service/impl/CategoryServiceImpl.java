package com.jerry.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Article;
import com.jerry.domain.entity.Category;
import com.jerry.domain.vo.CategoryVo;
import com.jerry.mapper.CategoryMapper;
import com.jerry.service.ArticleService;
import com.jerry.service.CategoryService;
import com.jerry.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 *
 * @author makejava
 * @since 2022-04-13 11:01:00
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private ArticleService articleService;

    @Override
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getStatus, 0);
        List<Article> list = articleService.list();
        Set<Long> categoryIds = list.stream().map(article -> article.getCategoryId())
                .collect(Collectors.toSet());

        List<Category> categories = listByIds(categoryIds);
        List<Category> categoriesFinal = categories.stream().filter(category -> "0".equals(category.getStatus()))
                .collect(Collectors.toList());
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categoriesFinal, CategoryVo.class);
        return ResponseResult.okResult(categoryVos);
    }
}
