package com.just.rocketmq.health.service;

import com.just.rocketmq.health.entity.HealthTask;
import java.util.List;

/**
 * (HealthTask)表服务接口
 *
 * @author makejava
 * @since 2020-09-22 16:35:00
 */
public interface HealthTaskService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HealthTask queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HealthTask> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param healthTask 实例对象
     * @return 实例对象
     */
    HealthTask insert(HealthTask healthTask);

    /**
     * 修改数据
     *
     * @param healthTask 实例对象
     * @return 实例对象
     */
    HealthTask update(HealthTask healthTask);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}