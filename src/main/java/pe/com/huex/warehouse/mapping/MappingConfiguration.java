package pe.com.huex.warehouse.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("warehouseMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public InvoicedProductMapping invoicedProductMapping() {
        return new InvoicedProductMapping();
    }
}
