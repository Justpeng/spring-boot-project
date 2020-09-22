package com.just.shardingsphere.health.entity;

import java.io.Serializable;

/**
 * (HealthUser)实体类
 *
 * @author makejava
 * @since 2020-09-22 16:35:22
 */
public class HealthUser implements Serializable {
    private static final long serialVersionUID = -98228520277691262L;
    /**
    * 主键id
    */
    private Object id;
    /**
    * 姓名
    */
    private String userName;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}