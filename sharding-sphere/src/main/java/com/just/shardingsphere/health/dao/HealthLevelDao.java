package com.just.shardingsphere.health.dao;

import com.just.shardingsphere.health.entity.HealthLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthLevel)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-22 16:13:48
 */
public interface HealthLevelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HealthLevel queryById(Object id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HealthLevel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param healthLevel 实例对象
     * @return 对象列表
     */
    List<HealthLevel> queryAll(HealthLevel healthLevel);

    /**
     * 新增数据
     *
     * @param healthLevel 实例对象
     * @return 影响行数
     */
    int insert(HealthLevel healthLevel);

    /**
     * 修改数据
     *
     * @param healthLevel 实例对象
     * @return 影响行数
     */
    int update(HealthLevel healthLevel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}