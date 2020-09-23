package com.just.shardingsphere.health.controller;

import com.just.shardingsphere.health.entity.HealthLevel;
import com.just.shardingsphere.health.service.HealthLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (HealthLevel)表控制层
 *
 * @author makejava
 * @since 2020-09-22 16:13:52
 */
@RestController
@RequestMapping("healthLevel")
public class HealthLevelController {
    /**
     * 服务对象
     */
    @Resource
    private HealthLevelService healthLevelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HealthLevel selectOne(Long id) {
        return this.healthLevelService.queryById(id);
    }

}