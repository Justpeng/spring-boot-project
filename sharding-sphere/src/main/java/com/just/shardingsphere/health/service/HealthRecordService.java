package com.just.shardingsphere.health.service;

import com.just.shardingsphere.health.entity.HealthRecord;
import java.util.List;

/**
 * (HealthRecord)表服务接口
 *
 * @author makejava
 * @since 2020-09-22 16:33:43
 */
public interface HealthRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    HealthRecord queryById(Object id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<HealthRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param healthRecord 实例对象
     * @return 实例对象
     */
    HealthRecord insert(HealthRecord healthRecord);

    /**
     * 修改数据
     *
     * @param healthRecord 实例对象
     * @return 实例对象
     */
    HealthRecord update(HealthRecord healthRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);

}