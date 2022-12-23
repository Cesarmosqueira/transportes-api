package pe.com.huex.security.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.huex.vehicles.mapping.*;

@Configuration("securityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public UserMapping userMapping() {
        return new UserMapping();
    }
}
