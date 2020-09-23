package com.just.shardingsphere;

import com.just.shardingsphere.health.entity.HealthLevel;
import com.just.shardingsphere.health.entity.HealthRecord;
import com.just.shardingsphere.health.entity.HealthTask;
import com.just.shardingsphere.health.entity.HealthUser;
import com.just.shardingsphere.health.service.HealthLevelService;
import com.just.shardingsphere.health.service.HealthRecordService;
import com.just.shardingsphere.health.service.HealthTaskService;
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
        int i =10;
        while (i > 0) {
            HealthUser healthUser = new HealthUser();
            healthUser.setUserName("name" + i);
            healthUserService.insert(healthUser);
            i--;
        }
    }


}
