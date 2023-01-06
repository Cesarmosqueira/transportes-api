package pe.com.huex.security.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapping userMapping() {
        return new UserMapping();
    }

    @Bean
    public MenuMapping menuMapping() {
        return new MenuMapping();
    }

    @Bean
    public UserMenuMapping userMenuMapping() {
        return new UserMenuMapping();
    }
}
