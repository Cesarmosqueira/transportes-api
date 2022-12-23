package pe.com.huex.services.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.response.*;

public interface ISettlementSummaryService {

    ResponseDto<SettlementSummaryListResponse> listSettlementSummary();

    ResponseDto<SettlementSummaryResponse> retrieveSettlementSummary(Long id);

    ResponseDto<SettlementSummaryResponse> registerSettlementSummary(SettlementSummaryDto settlementSummaryDto);

    ResponseDto<SettlementSummaryResponse> updateSettlementSummary(SettlementSummaryDto settlementSummaryDto);
}
