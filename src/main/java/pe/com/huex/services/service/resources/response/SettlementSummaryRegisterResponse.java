package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class SettlementSummaryRegisterResponse {

    private SettlementSummaryDto settlementSummaryDto = null;

    public SettlementSummaryRegisterResponse settlementSummaryRegisterResponse(SettlementSummaryDto settlementSummaryDto) {
        this.settlementSummaryDto = settlementSummaryDto;
        return this;
    }
}
