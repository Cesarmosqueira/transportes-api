package pe.com.huex.servicetracking.service.resources.response;

import lombok.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.response.RateRegisterResponse;
import pe.com.huex.servicetracking.service.resources.dto.ExpenseTypeDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTypeRegisterResponse {

    private ExpenseTypeDto expenseTypeDto = null;

    public ExpenseTypeRegisterResponse expenseTypeRegisterResponse(ExpenseTypeDto expenseTypeDto) {
        this.expenseTypeDto = expenseTypeDto;
        return this;
    }
}
