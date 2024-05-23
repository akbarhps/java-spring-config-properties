package com.charuniverse.springconfigproperties.p_conversion_service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("application")
public class ApplicationProperties {

    private String name;
    private Integer version;
    private Boolean productionMode;
    private Date defaultDate;
    private Duration defaultTimeout;
    private DatabaseProperties database;

    @Getter
    @Setter
    public static class DatabaseProperties {
        private String url;
        private String username;
        private String password;
        private String database;
        private List<String> whiteListTables;
        private Map<String, Integer> maxTableSize;
        private List<Role> defaultRoles;
        private Map<String, Role> roles;
    }

    @Getter
    @Setter
    public static class Role {
        private String id;
        private String name;
    }

}
