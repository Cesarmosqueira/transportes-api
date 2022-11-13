package pe.com.huex.servicetracking.service.resources.response;

import lombok.*;
import pe.com.huex.servicetracking.service.resources.dto.ExpenseTypeDto;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTypeRetrieveResponse {

    private ExpenseTypeDto expenseTypeDto = null;

    public ExpenseTypeRetrieveResponse expenseTypeRetrieveResponse(ExpenseTypeDto expenseTypeDto) {
        this.expenseTypeDto = expenseTypeDto;
        return this;
    }
}