package ru.netology.springBootDemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springBootDemo.profiles.DevProfile;
import ru.netology.springBootDemo.profiles.ProductionProfile;
import ru.netology.springBootDemo.profiles.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev",  havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev",  havingValue = "false", matchIfMissing = true)
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
