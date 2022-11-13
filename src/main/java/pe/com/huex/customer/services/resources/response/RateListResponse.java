package pe.com.huex.customer.services.resources.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import pe.com.huex.customer.services.resources.dto.RateDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class RateListResponse {

    private List<RateDto> rateDtoList = null;

    public RateListResponse rateListResponse(List<RateDto> rateDtoList) {
        this.rateDtoList = rateDtoList;
        return this;
    }
}
