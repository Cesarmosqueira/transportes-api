package pe.com.huex.services.service.resources.response;


import lombok.*;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.dto.TrackingServiceDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class SettlementSummaryUpdateResponse {

    private SettlementSummaryDto settlementSummaryDto = null;

    public SettlementSummaryUpdateResponse settlementSummaryUpdateResponse(SettlementSummaryDto settlementSummaryDto) {
        this.settlementSummaryDto = settlementSummaryDto;
        return this;
    }
}
