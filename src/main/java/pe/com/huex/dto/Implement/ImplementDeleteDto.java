package pe.com.huex.dto.Implement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImplementDeleteDto {

	private Long implement_id;

	public ImplementDeleteDto() {
	}

	public ImplementDeleteDto implement(Long implement_id) {
		this.implement_id = implement_id;
		return this;
	}

}
