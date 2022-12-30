package pe.com.huex.employees.services.resources.dtos;

import lombok.Data;
import pe.com.huex.employees.domain.entities.Implement;

@Data
public class ImplementDto {
	private Long id;

	private String name;

	private String description;

	private boolean available;

	private int stock;

	public ImplementDto(Implement implement) {
		this.id = implement.getId();
		this.name = implement.getName();
		this.description = implement.getDescription();
		this.available = implement.isAvailable();
		this.stock = implement.getStock();

	}
}
