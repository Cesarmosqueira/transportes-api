package pe.com.huex.vehicles.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("vehiclesMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public CheckListMapping checkListMapping() {
        return new CheckListMapping();
    }

    @Bean
    public DocumentUnitMapping documentUnitMapping() {
        return new DocumentUnitMapping();
    }

    @Bean
    public KardexFuelMapping kardexFuelMapping() {
        return new KardexFuelMapping();
    }

    @Bean
    public MaintenanceOilMapping maintenanceOilMapping() {
        return new MaintenanceOilMapping();
    }

    @Bean
    public TruckFleetMapping truckFleetMapping() {
        return new TruckFleetMapping();
    }
}
