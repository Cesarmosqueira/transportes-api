package pe.com.huex.services.service.resources.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

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
