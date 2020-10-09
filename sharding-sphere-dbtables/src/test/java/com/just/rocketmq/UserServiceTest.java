package com.just.rocketmq;

import com.just.rocketmq.health.entity.HealthUser;
import com.just.rocketmq.health.service.HealthUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
