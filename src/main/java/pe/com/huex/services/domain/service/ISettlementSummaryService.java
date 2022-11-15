package pe.com.huex.services.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.response.*;

public interface ISettlementSummaryService {

    ResponseDto<SettlementSummaryListResponse> listSettlementSummary();

    ResponseDto<SettlementSummaryRetrieveResponse> retrieveSettlementSummary(Long id);

    ResponseDto<SettlementSummaryRegisterResponse> registerSettlementSummary(SettlementSummaryDto settlementSummaryDto);

    ResponseDto<SettlementSummaryUpdateResponse> updateSettlementSummary(SettlementSummaryDto settlementSummaryDto);
}
