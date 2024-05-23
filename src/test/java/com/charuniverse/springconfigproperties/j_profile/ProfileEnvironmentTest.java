package com.charuniverse.springconfigproperties.j_profile;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@SpringBootTest(classes = ProfileEnvironmentTest.TestApplication.class)
@ActiveProfiles({"produksi"})
@TestPropertySources({
        @TestPropertySource("classpath:/test.properties")
})
public class ProfileEnvironmentTest {

    @Autowired
    private TestApplication.SampleProfile sampleProfile;

    @Test
    void testActiveProfiles() {
        var profiles = sampleProfile.getProfiles();
        Assertions.assertEquals(1, profiles.length);
        Assertions.assertEquals("produksi", profiles[0]);
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleProfile implements EnvironmentAware {

            @Setter
            private Environment environment;

            public String[] getProfiles() {
                return environment.getActiveProfiles();
            }
        }
    }
}
