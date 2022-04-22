package com.jerry.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleDetailVo {
    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类id
    private String categoryName;
    //所属分类id
    private Long categoryId;

    private String content;
    //缩略图
    private String thumbnail;

    private Long viewCount;

    private Date createTime;
}
