package pe.com.huex.servicetracking.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.response.RateUpdateResponse;
import pe.com.huex.servicetracking.service.resources.dto.ExpenseTypeDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTypeUpdateResponse {

    private ExpenseTypeDto expenseTypeDto = null;

    public ExpenseTypeUpdateResponse expenseTypeUpdateResponse(ExpenseTypeDto expenseTypeDto) {
        this.expenseTypeDto = expenseTypeDto;
        return this;
    }
}
