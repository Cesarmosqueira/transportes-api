package pe.com.huex.services.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.response.ExpenseTypeListResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeRegisterResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeRetrieveResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeUpdateResponse;

public interface IExpenseTypeService {

    ResponseDto<ExpenseTypeListResponse> listExpenseType();

    ResponseDto<ExpenseTypeRetrieveResponse> retrieveExpenseType(Long id);

    ResponseDto<ExpenseTypeRegisterResponse> registerExpenseType(ExpenseTypeDto expenseTypeDto);

    ResponseDto<ExpenseTypeUpdateResponse> updateExpenseType(ExpenseTypeDto expenseTypeDto);
}
