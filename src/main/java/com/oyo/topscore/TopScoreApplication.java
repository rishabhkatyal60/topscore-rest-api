package com.oyo.topscore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopScoreApplication {

    private static final Logger logger = LoggerFactory.getLogger(TopScoreApplication.class);

    public static void main(String[] args) {
        logger.info("Init the application...");
        SpringApplication.run(TopScoreApplication.class, args);
    }
}
