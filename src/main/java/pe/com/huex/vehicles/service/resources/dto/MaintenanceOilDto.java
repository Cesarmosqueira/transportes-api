package pe.com.huex.vehicles.service.resources.dto;

import lombok.*;
import pe.com.huex.employees.domain.entities.Employee;
import pe.com.huex.employees.services.resources.dtos.EmployeeDto;
import pe.com.huex.providers.domain.model.entity.Provider;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.dto.ProviderMaintenanceDto;
import pe.com.huex.providers.service.resouces.dto.ProviderRelationDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceEmployeeDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceTruckFleetDto;
import pe.com.huex.vehicles.domain.entities.TruckFleet;

import java.util.Date;

@Getter
@Setter
public class MaintenanceOilDto {
    private Long id;
    private ProviderRelationDto provider;
    private TrackingServiceEmployeeDto employee;
    private TrackingServiceTruckFleetDto truckFleet;
    private String changeType;
    private String place;
    private Date dateChange;
    private Integer kmLast;
    private Integer kmCurrent;
    private Integer kmNext;
    private String status;
    private Date dateCurrent;
    private Integer differences;
    private Double changeKm;
    private Double kmChangeMade;

}