package transportes.api.Services;

import java.util.List;

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

	public Trabajador registrarTrabajador(TrabajadorDtoRequest trabajadorDto) throws Exception {
		Trabajador trabajador = new Trabajador(trabajadorDto);
		return trabajadorRepository.save(trabajador);
	}

	public Trabajador obtenerTrabajador(Long id) throws Exception {
		return trabajadorRepository.findById(id)
				.orElseThrow(() -> new Exception("trabajador '" + id + "' no existe en la base de datos"));
	}

	public List<Trabajador> listarTrabajadores() {
		return trabajadorRepository.findAll();
	}

	public Trabajador actualizarTrabajador(Long id, TrabajadorDtoRequest trabajadorDto) throws Exception {
		Trabajador trabajador = trabajadorRepository.findById(id)
				.orElseThrow(() -> new Exception("trabajadir '" + id + "' no existe en la base de datos"));

		trabajador = new Trabajador(trabajadorDto);

		trabajador.setId(id);
		return trabajadorRepository.save(trabajador);
	}
}
