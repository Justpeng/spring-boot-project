package com.just.shardingsphere;

import com.just.shardingsphere.health.entity.HealthUser;
import com.just.shardingsphere.health.service.HealthUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private HealthUserService healthUserService;

    @Test
    public void testProcessUsers() throws Exception {
        List<HealthUser> list = healthUserService.queryAllByLimit(0, 10);
        Assert.assertEquals(true, list.isEmpty());
    }
}
