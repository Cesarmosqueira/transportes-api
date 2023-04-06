package pe.com.huex.warehouse.service.resources.response;

import lombok.Data;
import pe.com.huex.warehouse.service.resources.dto.OrderDetailDto;

@Data
public class OrderDetailResponse {

    private OrderDetailDto orderDetail = null;

    public OrderDetailResponse orderDetail(OrderDetailDto orderDetail) {
        this.orderDetail = orderDetail;
        return this;
    }
}
