package com.charuniverse.springconfigproperties.o_conversion;

import com.charuniverse.springconfigproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.Duration;

@SpringBootTest(classes = ConversionTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ConversionTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testConversionDuration() {
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getDefaultTimeout());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ApplicationProperties.class})
    public static class TestApplication {
    }
}
