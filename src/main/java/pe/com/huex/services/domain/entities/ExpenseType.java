package pe.com.huex.services.domain.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.customer.domain.entities.CustomerEmployee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "expense_type")
public class ExpenseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String expenseType;

    @Column(length = 200)
    private String description;

    @OneToMany(mappedBy = "expenseType", cascade = CascadeType.ALL)
    private List<SettlementSummary> settlementSummaries = new ArrayList<>();
}
