package pe.com.huex.services.service.resources.dto;

import lombok.*;
import pe.com.huex.services.domain.entities.ExpenseType;
import pe.com.huex.services.domain.entities.TrackingService;

import java.util.Date;

@Data
public class SettlementSummaryDto {

    private Long id;
    private TrackingService trackingService;
    private ExpenseType expenseType;
    private Date settlementDate;
    private String detail;
    private double totalExpense;


}
