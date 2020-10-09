package com.just.rocketmq.health.service.impl;

import com.just.rocketmq.health.entity.HealthRecord;
import com.just.rocketmq.health.dao.HealthRecordDao;
import com.just.rocketmq.health.service.HealthRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-09-22 16:33:43
 */
@Service("healthRecordService")
public class HealthRecordServiceImpl implements HealthRecordService {
    @Resource
    private HealthRecordDao healthRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HealthRecord queryById(Long id) {
        return this.healthRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HealthRecord> queryAllByLimit(int offset, int limit) {
        return this.healthRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param healthRecord 实例对象
     * @return 实例对象
     */
    @Override
    public HealthRecord insert(HealthRecord healthRecord) {
        this.healthRecordDao.insert(healthRecord);
        return healthRecord;
    }

    /**
     * 修改数据
     *
     * @param healthRecord 实例对象
     * @return 实例对象
     */
    @Override
    public HealthRecord update(HealthRecord healthRecord) {
        this.healthRecordDao.update(healthRecord);
        return this.queryById(healthRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.healthRecordDao.deleteById(id) > 0;
    }
}