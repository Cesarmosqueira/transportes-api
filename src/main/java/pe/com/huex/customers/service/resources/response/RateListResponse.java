package pe.com.huex.customers.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.dto.RuteDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateListResponse {


    private List<RateDto> rateDtoList=null;

    public RateListResponse rateListResponse(List<RateDto> rateDtoList){
        this.rateDtoList=rateDtoList;
        return this;
    }
}
