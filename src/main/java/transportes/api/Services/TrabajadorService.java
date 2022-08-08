package transportes.api.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transportes.api.Common.EntityDtoConverter;
import transportes.api.Dto.Request.TrabajadorDtoRequest;
import transportes.api.Entities.Trabajador;
import transportes.api.Repositories.TrabajadorRepository;

@Transactional
@Service
public class TrabajadorService {
	@Autowired
	TrabajadorRepository trabajadorRepository;

	@Autowired
	EntityDtoConverter entityDtoConverter;

	public Trabajador registrarTrabajador(TrabajadorDtoRequest trabajadorDto) {
		Trabajador trabajador = new Trabajador(trabajadorDto);
		return trabajadorRepository.save(trabajador);
	}

	public Trabajador obtenerTrabajador(Long id) {
		return trabajadorRepository.getById(id);
	}
}
