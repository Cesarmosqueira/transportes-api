package pe.com.huex.services.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.response.ExpenseTypeListResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeResponse;

public interface IExpenseTypeService {

    ResponseDto<ExpenseTypeListResponse> listExpenseType();

    ResponseDto<ExpenseTypeResponse> retrieveExpenseType(Long id);

    ResponseDto<ExpenseTypeResponse> registerExpenseType(ExpenseTypeDto expenseTypeDto);

    ResponseDto<ExpenseTypeResponse> updateExpenseType(ExpenseTypeDto expenseTypeDto);

    ResponseDto deleteExpenseType(Long id);

}
