package com.just.rocketmq.health.controller;

import com.just.rocketmq.health.entity.HealthRecord;
import com.just.rocketmq.health.service.HealthRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HealthRecord)表控制层
 *
 * @author makejava
 * @since 2020-09-22 16:33:43
 */
@RestController
@RequestMapping("healthRecord")
public class HealthRecordController {
    /**
     * 服务对象
     */
    @Resource
    private HealthRecordService healthRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HealthRecord selectOne(Long id) {
        return this.healthRecordService.queryById(id);
    }

}