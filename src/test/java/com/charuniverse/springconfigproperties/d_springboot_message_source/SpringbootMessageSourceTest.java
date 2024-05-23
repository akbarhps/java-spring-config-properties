package com.charuniverse.springconfigproperties.d_springboot_message_source;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringbootMessageSourceTest.TestApplication.class)
public class SpringbootMessageSourceTest {

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            public String hello(Locale locale, Object... args) {
                return messageSource.getMessage("hello", args, locale);
            }
        }
    }

    @Autowired
    private TestApplication.SampleSource source;

    @Test
    void testHello() {
        Assertions.assertEquals("Hello akbar", source.hello(Locale.getDefault(), "akbar"));
        Assertions.assertEquals("Halo akbar", source.hello(new Locale("in_ID"), "akbar"));
    }
}
