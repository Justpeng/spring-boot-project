package com.just.shardingsphere.health.service.impl;

import com.just.shardingsphere.health.entity.HealthTask;
import com.just.shardingsphere.health.dao.HealthTaskDao;
import com.just.shardingsphere.health.service.HealthTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthTask)表服务实现类
 *
 * @author makejava
 * @since 2020-09-22 16:35:00
 */
@Service("healthTaskService")
public class HealthTaskServiceImpl implements HealthTaskService {
    @Resource
    private HealthTaskDao healthTaskDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HealthTask queryById(Object id) {
        return this.healthTaskDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HealthTask> queryAllByLimit(int offset, int limit) {
        return this.healthTaskDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param healthTask 实例对象
     * @return 实例对象
     */
    @Override
    public HealthTask insert(HealthTask healthTask) {
        this.healthTaskDao.insert(healthTask);
        return healthTask;
    }

    /**
     * 修改数据
     *
     * @param healthTask 实例对象
     * @return 实例对象
     */
    @Override
    public HealthTask update(HealthTask healthTask) {
        this.healthTaskDao.update(healthTask);
        return this.queryById(healthTask.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.healthTaskDao.deleteById(id) > 0;
    }
}