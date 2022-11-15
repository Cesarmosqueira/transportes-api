package pe.com.huex.exception.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("servicesMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public TrackingServiceMapping trackingServiceMapping() {
        return new TrackingServiceMapping();
    }

    @Bean
    public ExpenseTypeMapping expenseTypeMapping() {
        return new ExpenseTypeMapping();
    }
    @Bean
    public SettlementSummaryMapping settlementSummaryMapping() {
        return new SettlementSummaryMapping();
    }


    @Bean
    public ServiceIncidentsMapping serviceIncidentsMapping() {
        return new ServiceIncidentsMapping();
    }

}
