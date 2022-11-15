package pe.com.huex.services.service.resources.dto;

import lombok.*;
import pe.com.huex.services.domain.model.entity.ExpenseType;
import pe.com.huex.services.domain.model.entity.TrackingService;

import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class SettlementSummaryDto {

    private Long id;
    private Long trackingServiceId;
    private Long expenseTypeId;
    private Date settlementDate;
    private String detail;
    private double totalExpense;


}
