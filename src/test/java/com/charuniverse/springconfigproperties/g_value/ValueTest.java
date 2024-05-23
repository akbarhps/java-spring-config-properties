package com.charuniverse.springconfigproperties.g_value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties applicationProperties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testApplicationProperties() {
        Assertions.assertEquals("akbar gemink", applicationProperties.getName());
        Assertions.assertEquals(1, applicationProperties.getVersion());
        Assertions.assertFalse(applicationProperties.getProductionMode());
    }

    @Test
    void testSystemProperties() {
//        var javaHome = systemProperties.getJavaHome();
        // doesn't work on windows!
        // Assertions.assertEquals("C:\Program Files\Java\jdk-22", javaHome);
    }

    @SpringBootApplication
    public static class TestApplication {

        @Getter
        @Component
        public static class SystemProperties {

//            @Value("${JAVA_HOME}")
//            private String javaHome;
        }

        @Getter
        @Component
        public static class ApplicationProperties {

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production-mode}")
            private Boolean productionMode;
        }
    }
}
