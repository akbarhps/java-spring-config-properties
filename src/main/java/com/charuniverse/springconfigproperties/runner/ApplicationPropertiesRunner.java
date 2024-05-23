package com.charuniverse.springconfigproperties.runner;

import com.charuniverse.springconfigproperties.properties.ApplicationProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class ApplicationPropertiesRunner implements ApplicationRunner {

    private ApplicationProperties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Name: {}", properties.getName());
        log.info("Version: {}", properties.getVersion());
        log.info("Production mode: {}", properties.getProductionMode());
    }
}
