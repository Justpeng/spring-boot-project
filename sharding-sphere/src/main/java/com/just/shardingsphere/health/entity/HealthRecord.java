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
    private Object id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 记录id
    */
    private Long recordId;
    /**
    * 级别id
    */
    private Long levelId;
    /**
    * 内容
    */
    private String remark;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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