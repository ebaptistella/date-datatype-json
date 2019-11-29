package com.github.ebaptistella.datedatatypejson.server;

import static com.github.ebaptistella.datedatatypejson.util.constants.UtilConstants.PKG_BASE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = { PKG_BASE })
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application-${spring.profiles.active}.properties")
@PropertySource(ignoreResourceNotFound = false, value = "classpath:application.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
