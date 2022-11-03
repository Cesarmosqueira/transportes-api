package pe.com.huex.servicetracking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.servicetracking.domain.entity.ExpenseType;
import pe.com.huex.servicetracking.service.ExpenseTypeService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("expense_type")
public class ExpenseTypeController {

    @Autowired
    ExpenseTypeService expenseTypeService;

    @PostMapping
    public ResponseEntity<ExpenseType> registerExpenseType(@Validated @RequestBody ExpenseType expenseType)
            throws Exception {
        expenseType = expenseTypeService.createExpenseType(expenseType);
        return new ResponseEntity<>(expenseType, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseType> retrieveExpenseType(@PathVariable Long id) throws Exception {
        ExpenseType expenseType = expenseTypeService.getExpenseType(id);
        return new ResponseEntity<>(expenseType, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseType>> listExpenseType() throws Exception {
        List<ExpenseType> expenseTypes = expenseTypeService.listExpenseType();
        return new ResponseEntity<>(expenseTypes, HttpStatus.OK);
    }
}
