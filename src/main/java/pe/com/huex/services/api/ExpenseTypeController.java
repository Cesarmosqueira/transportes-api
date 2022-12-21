package pe.com.huex.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.services.domain.service.IExpenseTypeService;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.response.ExpenseTypeListResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeRegisterResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeRetrieveResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeUpdateResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "expense_type", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExpenseTypeController {

    @Autowired
    IExpenseTypeService expenseTypeService;

    @GetMapping
    public ResponseDto<ExpenseTypeListResponse> listExpenseType() throws Exception {
        return expenseTypeService.listExpenseType();
    }

    @GetMapping(path = "{id}")
    public ResponseDto<ExpenseTypeRetrieveResponse> retrieveExpenseType(@PathVariable Long id) throws Exception {
        return expenseTypeService.retrieveExpenseType(id);
    }

    @PostMapping
    public ResponseDto<ExpenseTypeRegisterResponse> registerExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto)
            throws Exception {
        return expenseTypeService.registerExpenseType(expenseTypeDto);
    }

    @PutMapping
    public ResponseDto<ExpenseTypeUpdateResponse> updateExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto)
            throws Exception {
        return expenseTypeService.updateExpenseType(expenseTypeDto);
    }

}
