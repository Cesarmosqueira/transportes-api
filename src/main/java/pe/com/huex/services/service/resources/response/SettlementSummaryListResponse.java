package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class SettlementSummaryListResponse {

    private List<SettlementSummaryDto> settlementSummaryDtos = null;

    public SettlementSummaryListResponse settlementSummaryList(List<SettlementSummaryDto> settlementSummaryDtos) {
        this.settlementSummaryDtos = settlementSummaryDtos;
        return this;
    }
}
