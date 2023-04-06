package pe.com.huex.warehouse.service.resources.response;

import lombok.Data;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;
import pe.com.huex.warehouse.service.resources.dto.OrderDetailDto;

import java.util.List;

@Data
public class OrderDetailListResponse {

    private List<OrderDetailDto> orderDetail = null;

    public OrderDetailListResponse orderDetail(List<OrderDetailDto> orderDetail) {
        this.orderDetail = orderDetail;
        return this;
    }
}
