package pe.com.huex.services.domain.service;

import pe.com.huex.services.service.resources.dto.AdditionalServicesDto;
import pe.com.huex.services.service.resources.response.AdditionalServicesListResponse;
import pe.com.huex.services.service.resources.response.AdditionalServicesResponse;

import pe.com.huex.util.ResponseDto;

public interface IAdditionalServicesService {

    ResponseDto<AdditionalServicesListResponse> listAdditionalServices();

    ResponseDto<AdditionalServicesResponse> retrieveAdditionalServices(Long id);

    ResponseDto<AdditionalServicesResponse> registerAdditionalServices(AdditionalServicesDto additionalServicesDto);

    ResponseDto<AdditionalServicesResponse> updateAdditionalServices(AdditionalServicesDto additionalServicesDto);

    ResponseDto deleteAdditionalServices(Long id);
}
