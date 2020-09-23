package com.just.shardingsphere.health.dao;

import com.just.shardingsphere.health.entity.HealthRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-22 16:33:43
 */
public interface HealthRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HealthRecord queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HealthRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param healthRecord 实例对象
     * @return 对象列表
     */
    List<HealthRecord> queryAll(HealthRecord healthRecord);

    /**
     * 新增数据
     *
     * @param healthRecord 实例对象
     * @return 影响行数
     */
    int insert(HealthRecord healthRecord);

    /**
     * 修改数据
     *
     * @param healthRecord 实例对象
     * @return 影响行数
     */
    int update(HealthRecord healthRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}