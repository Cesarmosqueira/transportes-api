package pe.com.huex.services.service.resources.response;

import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

import java.util.List;

public class ExpenseTypeListResponse {

    private List<ExpenseTypeDto> expenseTypeDtoList=null;

    public ExpenseTypeListResponse expenseTypeListResponse(List<ExpenseTypeDto> expenseTypeDtoList){
        this.expenseTypeDtoList=expenseTypeDtoList;
        return this;
    }
}
