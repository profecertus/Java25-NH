package pe.nh.demo07.config;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class LocaleConfig {
    @PostConstruct
    void configurarLocale(){
        Locale.setDefault(Locale.forLanguageTag("es"));
    }
}
