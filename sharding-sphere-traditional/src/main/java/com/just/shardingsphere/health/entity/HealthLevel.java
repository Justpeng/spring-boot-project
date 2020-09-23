package com.just.shardingsphere.health.entity;

import java.io.Serializable;

/**
 * (HealthLevel)实体类
 *
 * @author makejava
 * @since 2020-09-22 16:13:41
 */
public class HealthLevel implements Serializable {
    private static final long serialVersionUID = 631881165538549332L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 级别名称
    */
    private String levelName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

}