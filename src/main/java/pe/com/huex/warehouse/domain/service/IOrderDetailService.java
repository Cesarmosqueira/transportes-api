package pe.com.huex.warehouse.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.warehouse.service.resources.dto.OrderDetailDto;
import pe.com.huex.warehouse.service.resources.response.OrderDetailListResponse;
import pe.com.huex.warehouse.service.resources.response.OrderDetailResponse;

public interface IOrderDetailService {

    ResponseDto<OrderDetailListResponse> listOrderDetail();

    ResponseDto<OrderDetailResponse> retrieveOrderDetail(Long id);

    ResponseDto<OrderDetailResponse> registerOrderDetail(OrderDetailDto orderDetailDto);

    ResponseDto<OrderDetailResponse> updateOrderDetail(OrderDetailDto orderDetailDto);

    ResponseDto deleteOrderDetail(Long id);
}
