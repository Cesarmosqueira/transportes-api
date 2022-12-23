package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

import java.util.List;

@Data
@NoArgsConstructor
public class SettlementSummaryListResponse {

    private List<SettlementSummaryDto> settlementsSummary = null;

    public SettlementSummaryListResponse settlementSummaryList(List<SettlementSummaryDto> settlementSummaryDtos) {
        this.settlementsSummary = settlementSummaryDtos;
        return this;
    }
}
