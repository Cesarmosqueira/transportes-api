package pe.com.huex.services.domain.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.domain.entities.Route;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "settlement_summary")
public class SettlementSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tracking_service", nullable = false)
    private TrackingService trackingService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_type", nullable = false)
    private ExpenseType expenseType;

    @Column(name = "settlement_date",nullable = false)
    private Date settlementDate;

    @Column(name = "detail",nullable = false)
    private String detail;

    @Column(name = "totalExpense",nullable = false)
    private double totalExpense;

}
