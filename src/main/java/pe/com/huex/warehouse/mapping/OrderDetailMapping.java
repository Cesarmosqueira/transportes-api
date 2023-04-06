package pe.com.huex.warehouse.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.warehouse.domain.model.entity.OrderDetail;
import pe.com.huex.warehouse.service.resources.dto.OrderDetailDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailMapping extends ModelMapper implements Serializable {

    public List<OrderDetailDto> modelList(List<OrderDetail> modelList) {
        return modelList.stream().map(item -> this.map(item, OrderDetailDto.class))
                .collect(Collectors.toList());
    }

    public OrderDetail model(OrderDetailDto modelDto) {

        return this.map(modelDto, OrderDetail.class);
    }

    public OrderDetailDto modelDto(OrderDetail model) {

        return this.map(model, OrderDetailDto.class);
    }
}
