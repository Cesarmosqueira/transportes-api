package pe.com.huex.providers.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("providersMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ProviderMapping providerMapping() {
        return new ProviderMapping();
    }

    @Bean
    public ProvinceEstivatorMapping provinceEstivatorMapping() {
        return new ProvinceEstivatorMapping();
    }

    @Bean
    public TireReplacementMapping tireReplacementMapping() {
        return new TireReplacementMapping();
    }

    @Bean
    public FuelSupplyMapping fuelSupplyMapping() {
        return new FuelSupplyMapping();
    }

    @Bean
    public KardexFuelMapping kardexFuelMapping() {
        return new KardexFuelMapping();
    }
}
