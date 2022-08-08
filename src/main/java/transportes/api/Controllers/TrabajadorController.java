package transportes.api.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transportes.api.Dto.TrabajadorDto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("trabajador")
public class TrabajadorController {
	@GetMapping
	public ResponseEntity<String> registrarTrabajador(@RequestBody TrabajadorDto trabajadorDto) {
		return null;
	}
}
