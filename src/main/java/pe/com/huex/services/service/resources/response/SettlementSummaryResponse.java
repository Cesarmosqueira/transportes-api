package pe.com.huex.services.service.resources.response;


import lombok.*;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;

@Data
@NoArgsConstructor
public class SettlementSummaryResponse {

    private SettlementSummaryDto settlementSummary = null;

    public SettlementSummaryResponse settlementSummary(SettlementSummaryDto settlementSummaryDto) {
        this.settlementSummary = settlementSummaryDto;
        return this;
    }
}
