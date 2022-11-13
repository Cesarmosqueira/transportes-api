package pe.com.huex.services.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("servicesMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public TrackingServiceMapping trackingServiceMapping() {
        return new TrackingServiceMapping();
    }

}
