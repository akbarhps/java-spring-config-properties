package com.charuniverse.springconfigproperties.c_message_source;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@SpringBootTest(classes = MessageSourceTest.TestApplication.class)
public class MessageSourceTest {

    @SpringBootApplication
    public static class TestApplication {

        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource source = new ResourceBundleMessageSource();
            source.setBasename("my");
            return source;
        }
    }

    private ApplicationContext context;
    private MessageSource messageSource;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestApplication.class);
        messageSource = context.getBean(MessageSource.class);
    }

    @Test
    void testDefaultLocale() {
        var message = messageSource.getMessage("hello", new Object[]{"Akbar"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Akbar", message);
    }

    @Test
    void testIDLocale() {
        var message = messageSource.getMessage("hello", new Object[]{"Akbar"}, new Locale("in_ID"));
        Assertions.assertEquals("Halo Akbar", message);
    }
}
