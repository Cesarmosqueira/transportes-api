package pe.com.huex.services.service.resources.dto;

import lombok.*;

import java.util.Date;

@Data
public class SettlementSummaryDto {

    private Long id;
    private Long trackingServiceId;
    private Long expenseTypeId;
    private Date settlementDate;
    private String detail;
    private double totalExpense;


}
