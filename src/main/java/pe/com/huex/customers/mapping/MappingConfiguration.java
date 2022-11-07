package pe.com.huex.customers.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.huex.providers.mapping.ProviderMapping;

@Configuration("ruteMappingConfiguration")

public class MappingConfiguration {
    @Bean
    public RuteMapping ruteMapping() {
        return new RuteMapping();
    }

    @Bean
    public RateMapping rateMapping() {
        return new RateMapping();
    }
}
