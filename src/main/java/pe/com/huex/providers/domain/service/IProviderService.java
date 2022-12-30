package pe.com.huex.providers.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface IProviderService {
    
    ResponseDto<ProviderListResponse> listProviders();

    ResponseDto<ProviderResponse> retrieveProvider(Long id);

    ResponseDto<ProviderResponse> registerProvider(ProviderDto providerDto);

    ResponseDto<ProviderResponse> updateProvider(ProviderDto providerDto);

    ResponseDto deleteProvider(Long id);

}
