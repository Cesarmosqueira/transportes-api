package transportes.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	// crear trabajador
	@PostMapping
	public ResponseEntity<Trabajador> registrarTrabajador(@RequestBody TrabajadorDtoRequest trabajadorDto) {
		Trabajador trabajador = trabajadorService.registrarTrabajador(trabajadorDto);
		return new ResponseEntity<>(trabajador, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<TrabajadorDtoResponse> obtenerTrabajador(@RequestParam Long id) {
		Trabajador trabajador = trabajadorService.obtenerTrabajador(id);
		TrabajadorDtoResponse response = new TrabajadorDtoResponse(trabajador);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
