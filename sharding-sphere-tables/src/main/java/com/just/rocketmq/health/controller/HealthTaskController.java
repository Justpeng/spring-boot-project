package com.just.rocketmq.health.controller;

import com.just.rocketmq.health.entity.HealthTask;
import com.just.rocketmq.health.service.HealthTaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HealthTask)表控制层
 *
 * @author makejava
 * @since 2020-09-22 16:35:00
 */
@RestController
@RequestMapping("healthTask")
public class HealthTaskController {
    /**
     * 服务对象
     */
    @Resource
    private HealthTaskService healthTaskService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HealthTask selectOne(Long id) {
        return this.healthTaskService.queryById(id);
    }

}