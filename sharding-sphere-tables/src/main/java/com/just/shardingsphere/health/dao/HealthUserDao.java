package com.just.shardingsphere.health.dao;

import com.just.shardingsphere.health.entity.HealthUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-22 16:35:22
 */
public interface HealthUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HealthUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HealthUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param healthUser 实例对象
     * @return 对象列表
     */
    List<HealthUser> queryAll(HealthUser healthUser);

    /**
     * 新增数据
     *
     * @param healthUser 实例对象
     * @return 影响行数
     */
    int insert(HealthUser healthUser);

    /**
     * 修改数据
     *
     * @param healthUser 实例对象
     * @return 影响行数
     */
    int update(HealthUser healthUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}