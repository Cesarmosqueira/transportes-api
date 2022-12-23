package pe.com.huex.services.service.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

import java.util.List;

@Data
@NoArgsConstructor
public class ExpenseTypeListResponse {

    private List<ExpenseTypeDto> expenseTypes = null;

    public ExpenseTypeListResponse expenseTypeList(List<ExpenseTypeDto> expenseTypeDtoList) {
        this.expenseTypes = expenseTypeDtoList;
        return this;
    }
}
