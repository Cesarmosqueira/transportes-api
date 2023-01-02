package pe.com.huex.services.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "settlement_summary")
public class SettlementSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tracking_service_id", nullable = false)
    private TrackingService trackingService;

    @ManyToOne
    @JoinColumn(name = "expense_type_id", nullable = false)
    private ExpenseType expenseType;

    @Column(name = "settlement_date",nullable = false)
    private Date settlementDate;

    @Column(name = "detail",nullable = false)
    private String detail;

    @Column(name = "totalExpense",nullable = false)
    private double totalExpense;

}
