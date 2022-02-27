package com.example.messagebundle.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@Configuration
public class LocaleConfiguration {

    @Bean
    public LocaleResolver localeResolver() {
        return new SmartLocaleResolver();
    }


    @Bean
    public ReloadableResourceBundleMessageSource messageSourceDesc() {
        return loadMessageSource("classpath:i18n/messages");
    }

    @Bean
    public ReloadableResourceBundleMessageSource errorDescBundle() {
        return loadMessageSource("classpath:i18n/error/desc");
    }

    @Bean
    public ReloadableResourceBundleMessageSource errorCodeBundle() {
        return loadMessageSource("classpath:i18n/error/code");
    }

    public ReloadableResourceBundleMessageSource loadMessageSource(String s) {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(s);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10); //reload messages every 10 seconds
        return messageSource;
    }

    public class SmartLocaleResolver extends AcceptHeaderLocaleResolver {

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            if (StringUtils.isEmpty(request.getHeader("Accept-Language"))) {
                return Locale.getDefault();
            }
            List<Locale.LanguageRange> list = Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
            Locale locale = Locale.lookup(list,Constants.getLocales());
            return locale ;
        }
    }
}
