package com.just.rocketmq.health.controller;

import com.just.rocketmq.health.entity.HealthUser;
import com.just.rocketmq.health.service.HealthUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HealthUser)表控制层
 *
 * @author makejava
 * @since 2020-09-22 16:35:22
 */
@RestController
@RequestMapping("healthUser")
public class HealthUserController {
    /**
     * 服务对象
     */
    @Resource
    private HealthUserService healthUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HealthUser selectOne(Long id) {
        return this.healthUserService.queryById(id);
    }

}