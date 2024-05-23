package com.charuniverse.springconfigproperties.f_environment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {

    @Autowired
    private Environment environment;

    @Test
    void testEnvironment() {
        var javaHome = environment.getProperty("JAVA_HOME");
        // doesn't work on windows!
        // Assertions.assertEquals("C:\Program Files\Java\jdk-22", appName);
        System.out.println(javaHome);
    }

    @SpringBootApplication
    public static class TestApplication {
    }
}
