package pe.com.huex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.entities.ExpenseType;
import pe.com.huex.entities.Rute;
import pe.com.huex.repositories.ExpenseTypeRepository;

import java.util.List;

@Service
public class ExpenseTypeService {

    @Autowired
    ExpenseTypeRepository expenseTypeRepository;

    public ExpenseType createExpenseType(ExpenseType expenseType) throws Exception {
        return expenseTypeRepository.save(expenseType);
    }

    public ExpenseType getExpenseType(Long id) throws Exception {
        return expenseTypeRepository.findById(id)
                .orElseThrow(() -> new Exception("Tipo gasto '" + id + "' no existe en la base de datos"));
    }

    public List<ExpenseType> listExpenseType() {

        return expenseTypeRepository.findAll();
    }

    public ExpenseType updateExpenseType(Long id, ExpenseType expenseType) throws Exception {
        expenseTypeRepository.findById(id)
                .orElseThrow(() -> new Exception("Tipo gasto '" + id + "' no existe en la base de datos"));

        expenseType.setId(id);
        return expenseTypeRepository.save(expenseType);
    }


}
