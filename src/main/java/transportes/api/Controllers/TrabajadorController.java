package transportes.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transportes.api.Common.EntityDtoConverter;
import transportes.api.Dto.Request.TrabajadorDtoRequest;
import transportes.api.Dto.Response.TrabajadorDtoResponse;
import transportes.api.Entities.Trabajador;
import transportes.api.Services.TrabajadorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("trabajador")
public class TrabajadorController {

	@Autowired
	TrabajadorService trabajadorService;

	@Autowired
	EntityDtoConverter entityDtoConverter;

	@PostMapping
	public ResponseEntity<Trabajador> registrarTrabajador(@Validated @RequestBody TrabajadorDtoRequest trabajadorDto)
			throws Exception {
		Trabajador trabajador = trabajadorService.registrarTrabajador(trabajadorDto);
		return new ResponseEntity<>(trabajador, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<TrabajadorDtoResponse> obtenerTrabajador(@PathVariable Long id) throws Exception {
		Trabajador trabajador = trabajadorService.obtenerTrabajador(id);
		TrabajadorDtoResponse response = new TrabajadorDtoResponse(trabajador);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<TrabajadorDtoResponse>> listarTrabajadores() throws Exception {
		List<Trabajador> trabajadores = trabajadorService.listarTrabajadores();
		List<TrabajadorDtoResponse> response = entityDtoConverter.convertTrabajadoresToDto(trabajadores);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Trabajador> registrarTrabajador(@PathVariable Long id,
			@Validated @RequestBody TrabajadorDtoRequest trabajadorDto)
			throws Exception {
		Trabajador trabajador = trabajadorService.actualizarTrabajador(id, trabajadorDto);
		return new ResponseEntity<>(trabajador, HttpStatus.OK);
	}

}
