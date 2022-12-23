package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

@Data
@NoArgsConstructor
public class ExpenseTypeResponse {

    private ExpenseTypeDto expenseType = null;

    public ExpenseTypeResponse expenseType(ExpenseTypeDto expenseTypeDto) {
        this.expenseType = expenseTypeDto;
        return this;
    }
}
