package pe.com.huex.providers.domain.service;

import pe.com.huex.dto.Response.ResponseDto;
import pe.com.huex.providers.service.resouces.dto.ProviderDto;
import pe.com.huex.providers.service.resouces.response.*;

public interface IProviderService {
    
    ResponseDto<ProviderListResponse> listProviders();

    ResponseDto<ProviderRetrieveResponse> retrieveProvider(Long id);

    ResponseDto<ProviderRegisterResponse> registerProvider(ProviderDto providerDto);

    ResponseDto<ProviderUpdateResponse> updateProvider(ProviderDto providerDto);
}
