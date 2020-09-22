package com.just.shardingsphere.health.service.impl;

import com.just.shardingsphere.health.entity.HealthUser;
import com.just.shardingsphere.health.dao.HealthUserDao;
import com.just.shardingsphere.health.service.HealthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HealthUser)表服务实现类
 *
 * @author makejava
 * @since 2020-09-22 16:35:22
 */
@Service("healthUserService")
public class HealthUserServiceImpl implements HealthUserService {
    @Resource
    private HealthUserDao healthUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public HealthUser queryById(Object id) {
        return this.healthUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<HealthUser> queryAllByLimit(int offset, int limit) {
        return this.healthUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param healthUser 实例对象
     * @return 实例对象
     */
    @Override
    public HealthUser insert(HealthUser healthUser) {
        this.healthUserDao.insert(healthUser);
        return healthUser;
    }

    /**
     * 修改数据
     *
     * @param healthUser 实例对象
     * @return 实例对象
     */
    @Override
    public HealthUser update(HealthUser healthUser) {
        this.healthUserDao.update(healthUser);
        return this.queryById(healthUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.healthUserDao.deleteById(id) > 0;
    }
}