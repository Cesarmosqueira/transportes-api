package pe.com.huex.services.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.services.domain.service.IExpenseTypeService;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;
import pe.com.huex.services.service.resources.response.ExpenseTypeListResponse;
import pe.com.huex.services.service.resources.response.ExpenseTypeResponse;

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
    public ResponseDto<ExpenseTypeResponse> retrieveExpenseType(@PathVariable Long id) throws Exception {
        return expenseTypeService.retrieveExpenseType(id);
    }

    @PostMapping
    public ResponseDto<ExpenseTypeResponse> registerExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto)
            throws Exception {
        return expenseTypeService.registerExpenseType(expenseTypeDto);
    }

    @PutMapping
    public ResponseDto<ExpenseTypeResponse> updateExpenseType(@RequestBody ExpenseTypeDto expenseTypeDto)
            throws Exception {
        return expenseTypeService.updateExpenseType(expenseTypeDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteExpenseType(@PathVariable Long id) {
        return expenseTypeService.deleteExpenseType(id);
    }

}
