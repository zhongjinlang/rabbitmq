package com.zhongjinlang.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: zhongjinlang
 * @date: Created in 2019/4/27 22:33
 * @description:
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
