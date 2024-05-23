package com.charuniverse.springconfigproperties.k_profile_properties_file;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfilePropertiesFileTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class ProfilePropertiesFileTest {

    @Autowired
    private TestApplication.ProfileProperties profileProperties;

    @Test
    void testProfileProperties() {
        Assertions.assertEquals("Default", profileProperties.getDefaultFile());
        Assertions.assertEquals("Test", profileProperties.getTestFile());
        Assertions.assertEquals("Production", profileProperties.getProductionFile());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Getter
        @Component
        public static class ProfileProperties {

            @Value("${profile.default}")
            private String defaultFile;

            @Value("${profile.test}")
            private String testFile;

            @Value("${profile.production}")
            private String productionFile;
        }
    }
}
