package pe.com.huex.customer.mapping;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import pe.com.huex.customer.domain.entities.Rate;
import pe.com.huex.customer.services.resources.dto.RateDto;

public class RateMapping extends ModelMapper implements Serializable {

    public RateMapping() {

        super();
    }

    public List<RateDto> modelList(List<Rate> modelList) {
        return modelList.stream().map(item -> this.map(item, RateDto.class))
                .collect(Collectors.toList());
    }

    public Rate model(RateDto rateDto) {
        return this.map(rateDto, Rate.class);
    }

    public RateDto modelDto(Rate rate) {
        return this.map(rate, RateDto.class);
    }
}
