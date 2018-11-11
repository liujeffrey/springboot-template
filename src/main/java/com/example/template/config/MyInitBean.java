package com.example.template.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyInitBean implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(MyInitBean.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("application init finish...");
    }
}
