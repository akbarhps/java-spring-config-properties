package com.charuniverse.springconfigproperties;

import com.charuniverse.springconfigproperties.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        ApplicationProperties.class
})
public class SpringConfigPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigPropertiesApplication.class, args);
    }

}
