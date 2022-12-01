package pe.com.huex.services.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.domain.service.ISettlementSummaryService;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;
import pe.com.huex.services.service.resources.response.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "settlement_summary", produces = MediaType.APPLICATION_JSON_VALUE)
public class SettlementSummaryController {

    private final ISettlementSummaryService settlementSummaryService;

    public SettlementSummaryController(ISettlementSummaryService settlementSummaryService) {
        this.settlementSummaryService = settlementSummaryService;
    }

    @GetMapping
    public ResponseDto<SettlementSummaryListResponse> listSettlementSummary() throws Exception {
        return settlementSummaryService.listSettlementSummary();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<SettlementSummaryRetrieveResponse> retrieveSettlementSummary(@PathVariable Long id) throws Exception {
        return settlementSummaryService.retrieveSettlementSummary(id);
    }

    @PostMapping
    public ResponseDto<SettlementSummaryRegisterResponse> registerSettlementSummary(@RequestBody SettlementSummaryDto settlementSummaryDto)
            throws Exception {
        return settlementSummaryService.registerSettlementSummary(settlementSummaryDto);
    }

    @PutMapping
    public ResponseDto<SettlementSummaryUpdateResponse> updateSettlementSummary(@RequestBody SettlementSummaryDto settlementSummaryDto)
            throws Exception {
        return settlementSummaryService.updateSettlementSummary(settlementSummaryDto);
    }
}