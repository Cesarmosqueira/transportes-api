package pe.com.huex.employees.services.resources.dtos;

import lombok.*;
import pe.com.huex.employees.domain.entities.Implement;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class ImplementDto {

	private Long id;

	private String name;

	private String description;



}
