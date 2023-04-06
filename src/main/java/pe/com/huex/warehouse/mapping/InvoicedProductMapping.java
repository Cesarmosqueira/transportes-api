package pe.com.huex.warehouse.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.warehouse.domain.model.entity.InvoicedProduct;
import pe.com.huex.warehouse.service.resources.dto.InvoicedProductDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class InvoicedProductMapping extends ModelMapper implements Serializable {

    public List<InvoicedProductDto> modelList(List<InvoicedProduct> modelList) {
        return modelList.stream().map(item -> this.map(item, InvoicedProductDto.class))
                .collect(Collectors.toList());
    }

    public InvoicedProduct model(InvoicedProductDto modelDto) {

        return this.map(modelDto, InvoicedProduct.class);
    }

    public InvoicedProductDto modelDto(InvoicedProduct model) {

        return this.map(model, InvoicedProductDto.class);
    }
}
