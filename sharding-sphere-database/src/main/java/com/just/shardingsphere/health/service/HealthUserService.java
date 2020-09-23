package com.just.shardingsphere.health.service;

import com.just.shardingsphere.health.entity.HealthUser;
import java.util.List;

/**
 * (HealthUser)表服务接口
 *
 * @author makejava
 * @since 2020-09-22 16:35:22
 */
public interface HealthUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HealthUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HealthUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param healthUser 实例对象
     * @return 实例对象
     */
    HealthUser insert(HealthUser healthUser);

    /**
     * 修改数据
     *
     * @param healthUser 实例对象
     * @return 实例对象
     */
    HealthUser update(HealthUser healthUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}