package pe.com.huex.operationsCosts.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("operationsCostsMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public TollMapping tollMapping() {
        return new TollMapping();
    }

    @Bean
    public RouteTollMapping routeTollMapping() {
        return new RouteTollMapping();
    }

}
