package com.example.template.task;

import org.apache.commons.io.FileCleaner;
import org.apache.commons.io.FileCleaningTracker;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * spring 定时任务，可以使用cron语法，http://www.bejson.com/othertools/cron/
 */
@Component
public class ScheduledTask {
    Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

    private int fileIndex = 1;

    /**
     * 每日凌晨3:00执行一次清理文件任务
     */
    @Scheduled(cron = "0 0 3 1/1 * ?")
    public void clearFileTask() {
        String tempDir = System.getProperty("user.dir") + File.separator + "temp";
        String filePath = tempDir + File.separator + "log" + fileIndex + ".txt";
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            logger.error("temp file " + filePath + " not exists");
            return;
        }
        boolean deleted = file.delete();
        fileIndex++;
        logger.info("delete temp file " + filePath + " " + deleted);
    }

    //每秒执行一次
//    @Scheduled(cron = "0 * * * * ?")
    public void printTask2() {
        logger.info("print task run...");
    }
}
