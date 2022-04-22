package com.jerry.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ArticleListVo {
    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类id
    private String categoryName;
    //缩略图
    private String thumbnail;

    private Long viewCount;

    private Date createTime;
}
