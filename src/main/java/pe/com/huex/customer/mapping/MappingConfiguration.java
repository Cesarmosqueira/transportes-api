package pe.com.huex.customer.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.huex.providers.mapping.ProviderMapping;

@Configuration("routeMappingConfiguration")

public class MappingConfiguration {
    @Bean
    public RouteMapping routeMapping() {
        return new RouteMapping();
    }

    @Bean
    public RateMapping rateMapping() {
        return new RateMapping();
    }

    @Bean
    public CustomerEmployeeMapping customerEmployeeMapping() {
        return new CustomerEmployeeMapping();
    }
}
