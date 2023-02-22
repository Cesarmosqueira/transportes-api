package pe.com.huex.employees.domain.service;

import pe.com.huex.employees.services.resources.dtos.DiscountDto;
import pe.com.huex.employees.services.resources.dtos.ProviderDiscountDto;
import pe.com.huex.employees.services.resources.response.DiscountListResponse;
import pe.com.huex.employees.services.resources.response.DiscountResponse;
import pe.com.huex.employees.services.resources.response.ProviderDiscountListResponse;
import pe.com.huex.employees.services.resources.response.ProviderDiscountResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

public interface IProviderDiscountService {

    ResponseDto<ProviderDiscountListResponse> listProviderDiscounts();

    ResponseDto<ProviderDiscountResponse> retrieveProviderDiscount(Long id);

    ResponseDto<ProviderDiscountResponse> registerProviderDiscount(ProviderDiscountDto providerDiscountDto) throws IOException;

    ResponseDto<ProviderDiscountResponse> updateProviderDiscount(ProviderDiscountDto providerDiscountDto) throws IOException;

    ResponseDto deleteProviderDiscount(Long id);
}
