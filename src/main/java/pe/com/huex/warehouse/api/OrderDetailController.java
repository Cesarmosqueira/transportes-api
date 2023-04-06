package pe.com.huex.warehouse.api;

import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.warehouse.domain.service.IOrderDetailService;
import pe.com.huex.warehouse.service.resources.dto.OrderDetailDto;
import pe.com.huex.warehouse.service.resources.response.OrderDetailListResponse;
import pe.com.huex.warehouse.service.resources.response.OrderDetailResponse;

@RestController
@RequestMapping("order_detail")
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;

    public OrderDetailController(IOrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping
    public ResponseDto<OrderDetailListResponse> listOrderDetail(){
        return orderDetailService.listOrderDetail();
    }
    @GetMapping("{id}")
    public ResponseDto<OrderDetailResponse> retrieveOrderDetail(@PathVariable Long id) {
        return orderDetailService.retrieveOrderDetail(id);
    }

    @PostMapping
    public ResponseDto<OrderDetailResponse>registerOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
        return orderDetailService.registerOrderDetail(orderDetailDto);
    }
    @PutMapping
    public ResponseDto<OrderDetailResponse>updateOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
        return orderDetailService.updateOrderDetail(orderDetailDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto deleteOrderDetail(@PathVariable Long id){
        return orderDetailService.deleteOrderDetail(id);
    }


}
