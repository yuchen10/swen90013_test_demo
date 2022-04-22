package com.jerry.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * primary key
     */
    private Long id;

    /**
     * nickname
     */
    private String nickName;

    /**
     * avatar
     */
    private String avatar;

    private String sex;

    private String email;


}
