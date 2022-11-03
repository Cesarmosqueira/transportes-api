package pe.com.huex.customers.service.resources.response;


import lombok.*;
import pe.com.huex.customers.service.resources.dto.RuteDto;
import pe.com.huex.vehicles.service.resources.dto.TruckFleetDto;
import pe.com.huex.vehicles.service.resources.response.TruckFleetListResponse;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RuteListResponse {



    private List<RuteDto>ruteDtoList=null;

    public RuteListResponse ruteListResponse(List<RuteDto> ruteDtoList){
        this.ruteDtoList=ruteDtoList;
        return this;
    }
}
