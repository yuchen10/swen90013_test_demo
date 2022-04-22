package com.jerry.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jerry.domain.ResponseResult;
import com.jerry.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-04-13 19:02:55
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLinks();
}


