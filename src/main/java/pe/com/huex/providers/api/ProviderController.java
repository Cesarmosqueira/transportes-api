package pe.com.huex.providers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.domain.service.IProviderService;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.ProviderListResponse;
import pe.com.huex.providers.service.resouces.response.ProviderResponse;

@RestController
@RequestMapping(value = "provider", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProviderController {

	@Autowired
	IProviderService providerService;

	@GetMapping
	public ResponseDto<ProviderListResponse> listProviders() throws Exception {
		return providerService.listProviders();
	}

	@GetMapping(path = "{id}")
	public ResponseDto<ProviderResponse> retrieveProviders(@PathVariable Long id) throws Exception {
		return providerService.retrieveProvider(id);
	}

	@PostMapping
	public ResponseDto<ProviderResponse> registerProviders(@RequestBody ProviderDto providerDto) throws Exception {
		return providerService.registerProvider(providerDto);
	}

	@PutMapping
	public ResponseDto<ProviderResponse> updateProviders(@RequestBody ProviderDto providerDto)
			throws Exception {
		return providerService.updateProvider(providerDto);
	}

	@DeleteMapping("{id}")
	public ResponseDto deleteProvider(@PathVariable Long id) {
		return providerService.deleteProvider(id);
	}
}
