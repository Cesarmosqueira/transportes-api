package pe.com.huex.servicetracking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.customers.service.resources.dto.RateDto;
import pe.com.huex.customers.service.resources.response.RateListResponse;
import pe.com.huex.customers.service.resources.response.RateRegisterResponse;
import pe.com.huex.customers.service.resources.response.RateRetrieveResponse;
import pe.com.huex.customers.service.resources.response.RateUpdateResponse;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.servicetracking.domain.model.entity.ExpenseType;
import pe.com.huex.servicetracking.domain.service.IExpenseTypeService;
import pe.com.huex.servicetracking.service.ExpenseTypeService;
import pe.com.huex.servicetracking.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.servicetracking.service.resources.response.ExpenseTypeListResponse;
import pe.com.huex.servicetracking.service.resources.response.ExpenseTypeRegisterResponse;
import pe.com.huex.servicetracking.service.resources.response.ExpenseTypeRetrieveResponse;
import pe.com.huex.servicetracking.service.resources.response.ExpenseTypeUpdateResponse;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("expense_type")
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
    public ResponseDto<ExpenseTypeRegisterResponse> registerExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto) throws Exception {
        return expenseTypeService.registerExpenseType(expenseTypeDto);
    }

    @PutMapping
    public ResponseDto<ExpenseTypeUpdateResponse> updateExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto)
            throws Exception {
        return expenseTypeService.updateExpenseType(expenseTypeDto);
    }

}
