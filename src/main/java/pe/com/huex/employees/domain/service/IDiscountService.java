package pe.com.huex.employees.domain.service;

import pe.com.huex.employees.services.resources.dtos.DiscountDto;
import pe.com.huex.employees.services.resources.response.DiscountListResponse;
import pe.com.huex.employees.services.resources.response.DiscountResponse;
import pe.com.huex.util.ResponseDto;

import java.io.IOException;

public interface IDiscountService {

    ResponseDto<DiscountListResponse> listDiscounts();

    ResponseDto<DiscountResponse> retrieveDiscount(Long id);

    ResponseDto<DiscountResponse> registerDiscount(DiscountDto discountDto) throws IOException;

    ResponseDto<DiscountResponse> updateDiscount(DiscountDto discountDto) throws IOException;

    ResponseDto deleteDiscount(Long id);
}
