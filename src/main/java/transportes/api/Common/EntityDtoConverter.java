package transportes.api.Common;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import transportes.api.Dto.Response.TrabajadorDtoResponse;
import transportes.api.Entities.Trabajador;

@Component
public class EntityDtoConverter {
	private final ModelMapper modelMapper;

	public EntityDtoConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public List<TrabajadorDtoResponse> convertTrabajadoresToDto(List<Trabajador> trabajadores) {
		List<TrabajadorDtoResponse> dtos = new ArrayList<TrabajadorDtoResponse>();
		for (Trabajador trabajador : trabajadores) {
			dtos.add(new TrabajadorDtoResponse(trabajador));
		}
		return dtos;
	}

}
