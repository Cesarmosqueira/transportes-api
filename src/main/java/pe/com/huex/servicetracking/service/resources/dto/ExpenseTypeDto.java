package pe.com.huex.servicetracking.service.resources.dto;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseTypeDto {

    private Long id;
    private String expenseType;
    private String description;

}
