package pe.com.huex.services.service.resources.response;

import lombok.*;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTypeListResponse {

    private List<ExpenseTypeDto> expenseTypeDtoList=null;

    public ExpenseTypeListResponse expenseTypeListResponse(List<ExpenseTypeDto> expenseTypeDtoList){
        this.expenseTypeDtoList=expenseTypeDtoList;
        return this;
    }
}
