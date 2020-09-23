package com.just.shardingsphere.health.entity;

import java.io.Serializable;

/**
 * (HealthRecord)实体类
 *
 * @author makejava
 * @since 2020-09-22 16:33:43
 */
public class HealthRecord implements Serializable {
    private static final long serialVersionUID = 942713526761321063L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;

    /**
    * 级别id
    */
    private Long levelId;
    /**
    * 内容
    */
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}