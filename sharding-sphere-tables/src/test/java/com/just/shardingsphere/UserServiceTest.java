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

    @Autowired
    private HealthLevelService healthLevelService;

    @Autowired
    private HealthRecordService healthRecordService;

    @Autowired
    private HealthTaskService healthTaskService;

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

    @Test
    public void testProcessLevel() throws Exception {
        long userId = 515489213915992065L;
        int i =10;
        while (i > 0) {
            HealthLevel healthLevel = new HealthLevel();
            healthLevel.setLevelName("level-name" + i);
            healthLevelService.insert(healthLevel);
            i--;
        }
    }

    @Test
    public void testProcessRecord() throws Exception {

        long userId = 515489213915992065L;
        long levelId = 515507479459794944L;
        int i =10;
        while (i > 0) {
            HealthRecord healthRecord = new HealthRecord();
            healthRecord.setLevelId(levelId);
            healthRecord.setUserId(levelId);
            healthRecord.setLevelId(userId);
            healthRecord.setRemark("remark" + i);
            healthRecordService.insert(healthRecord);
            i--;
        }
    }

    @Test
    public void testProcessTask() throws Exception {
        long userId = 515489213915992065L;
        long recordId = 515508442853675008L;
        int i =10;
        while (i > 0) {
            HealthTask healthRecord = new HealthTask();
            healthRecord.setUserId(userId);
            healthRecord.setRecordId(recordId);
            healthRecord.setTaskName("task" + i);
            healthTaskService.insert(healthRecord);
            i--;
        }
    }

}
