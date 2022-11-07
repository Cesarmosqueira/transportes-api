package pe.com.huex.servicetracking.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.huex.customers.mapping.RuteMapping;

@Configuration("expenseTypeMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ExpenseTypeMapping expenseTypeMapping() {
        return new ExpenseTypeMapping();
    }


}
