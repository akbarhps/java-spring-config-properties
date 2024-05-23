package com.charuniverse.springconfigproperties.l_configuration_properties;

import com.charuniverse.springconfigproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("akbar gemink", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertFalse(properties.getProductionMode());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ApplicationProperties.class})
    public static class TestApplication {
    }
}
