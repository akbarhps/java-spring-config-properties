package com.charuniverse.springconfigproperties.n_collection_configuration_properties;

import com.charuniverse.springconfigproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest(classes = CollectionConfigurationPropertiesTest.TestApplication.class)
@ActiveProfiles({"production", "test"})
public class CollectionConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testCollectionDatabaseProperties() {
        Assertions.assertEquals("db_username", properties.getDatabase().getUsername());
        Assertions.assertEquals("db_password", properties.getDatabase().getPassword());
        Assertions.assertEquals("database", properties.getDatabase().getDatabase());
        Assertions.assertEquals("localhost", properties.getDatabase().getUrl());

        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), properties.getDatabase().getWhiteListTables());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("products"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("customers"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTableSize().get("categories"));

        Assertions.assertEquals(2, properties.getDatabase().getDefaultRoles().size());
        Assertions.assertEquals("default", properties.getDatabase().getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", properties.getDatabase().getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", properties.getDatabase().getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", properties.getDatabase().getDefaultRoles().get(1).getName());

        Assertions.assertEquals(2, properties.getDatabase().getRoles().size());
        Assertions.assertEquals("admin", properties.getDatabase().getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", properties.getDatabase().getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getDatabase().getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", properties.getDatabase().getRoles().get("finance").getName());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({ApplicationProperties.class})
    public static class TestApplication {
    }
}
