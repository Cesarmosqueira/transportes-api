package pe.com.huex.services.mapping;

import org.modelmapper.ModelMapper;

import pe.com.huex.services.domain.entities.ExpenseType;
import pe.com.huex.services.service.resources.dto.ExpenseTypeDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseTypeMapping extends ModelMapper implements Serializable {

    public ExpenseTypeMapping() {

        super();
    }

    public List<ExpenseTypeDto> modelList(List<ExpenseType> modelList) {
        return modelList.stream().map(item -> this.map(item, ExpenseTypeDto.class))
                .collect(Collectors.toList());
    }

    public ExpenseType model(ExpenseTypeDto expenseTypeDto) {

        return this.map(expenseTypeDto, ExpenseType.class);
    }

    public ExpenseTypeDto modelDto(ExpenseType expenseType) {

        return this.map(expenseType, ExpenseTypeDto.class);
    }
}
