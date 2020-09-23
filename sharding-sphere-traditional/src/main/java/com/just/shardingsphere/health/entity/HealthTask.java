package com.just.shardingsphere.health.entity;

import java.io.Serializable;

/**
 * (HealthTask)实体类
 *
 * @author makejava
 * @since 2020-09-22 16:35:00
 */
public class HealthTask implements Serializable {
    private static final long serialVersionUID = 502295537782711083L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 任务id
    */
    private String recordId;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 任务名称
    */
    private String taskName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}