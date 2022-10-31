package pe.com.huex.providers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.domain.service.IProviderService;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.ProviderListResponse;
import pe.com.huex.providers.service.resouces.response.ProviderRegisterResponse;
import pe.com.huex.providers.service.resouces.response.ProviderRetrieveResponse;
import pe.com.huex.providers.service.resouces.response.ProviderUpdateResponse;

@CrossOrigin(origins = "*")
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
	public ResponseDto<ProviderRetrieveResponse> retrieveProviders(@PathVariable Long id) throws Exception {
		return providerService.retrieveProvider(id);
	}

	@PostMapping
	public ResponseDto<ProviderRegisterResponse> registerProviders(@RequestBody ProviderDto providerDto) throws Exception {
		return providerService.registerProvider(providerDto);
	}

	@PutMapping
	public ResponseDto<ProviderUpdateResponse> updateProviders(@RequestBody ProviderDto providerDto)
			throws Exception {
		return providerService.updateProvider(providerDto);
	}
}
