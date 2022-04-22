package com.jerry.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-04-13 11:01:00
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}


