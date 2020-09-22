package com.just.shardingsphere.health.service.impl;

import com.just.shardingsphere.health.dao.HealthLevelDao;
import com.just.shardingsphere.health.entity.HealthLevel;
import com.just.shardingsphere.health.service.HealthLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthLevel)表服务实现类
 *
 * @author makejava
 * @since 2020-09-22 16:13:51
 */
@Service("healthLevelService")
public class HealthLevelServiceImpl implements HealthLevelService {

    @Resource
    private HealthLevelDao healthLevelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HealthLevel queryById(Object id) {
        return this.healthLevelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HealthLevel> queryAllByLimit(int offset, int limit) {
        return this.healthLevelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param healthLevel 实例对象
     * @return 实例对象
     */
    @Override
    public HealthLevel insert(HealthLevel healthLevel) {
        this.healthLevelDao.insert(healthLevel);
        return healthLevel;
    }

    /**
     * 修改数据
     *
     * @param healthLevel 实例对象
     * @return 实例对象
     */
    @Override
    public HealthLevel update(HealthLevel healthLevel) {
        this.healthLevelDao.update(healthLevel);
        return this.queryById(healthLevel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.healthLevelDao.deleteById(id) > 0;
    }
}