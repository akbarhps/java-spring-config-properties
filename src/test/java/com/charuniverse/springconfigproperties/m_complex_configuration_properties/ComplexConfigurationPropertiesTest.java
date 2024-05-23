package com.charuniverse.springconfigproperties.m_complex_configuration_properties;

import com.charuniverse.springconfigproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ComplexConfigurationPropertiesTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ComplexConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("db_username", properties.getDatabase().getUsername());
        Assertions.assertEquals("db_password", properties.getDatabase().getPassword());
        Assertions.assertEquals("database", properties.getDatabase().getDatabase());
        Assertions.assertEquals("localhost", properties.getDatabase().getUrl());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ApplicationProperties.class})
    public static class TestApplication {
    }
}
