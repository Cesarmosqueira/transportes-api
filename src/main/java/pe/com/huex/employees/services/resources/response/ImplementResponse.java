package pe.com.huex.employees.services.resources.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pe.com.huex.employees.services.resources.dtos.ImplementDto;

@Data
public class ImplementResponse {

	private ImplementDto implement = null;

	public ImplementResponse implement(ImplementDto implementDto) {
		this.implement = implementDto;
		return this;
	}

}
