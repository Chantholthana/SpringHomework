package com.chanthol.test03.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

@Controller
public class MessageSourceConfiguration {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource=
                new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("i18n/messages");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return resourceBundleMessageSource;
    }
}
