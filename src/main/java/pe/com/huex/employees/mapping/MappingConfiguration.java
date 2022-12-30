package pe.com.huex.employees.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pe.com.huex.vehicles.mapping.*;

@Configuration("employeesMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public AttendanceMapping attendanceMapping() {
        return new AttendanceMapping();
    }
    @Bean
    public DiscountMapping discountMapping() {
        return new DiscountMapping();
    }
    @Bean
    public EmployeeMapping employeeMapping() {
        return new EmployeeMapping();
    }
    @Bean
    public ImplementMapping implementMapping() {
        return new ImplementMapping();
    }
}
