package pe.com.huex.providers.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.providers.domain.model.entity.ProvinceEstivators;
import pe.com.huex.providers.service.resouces.dto.ProvinceEstivatorDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ProvinceEstivatorMapping extends ModelMapper implements Serializable {

    public ProvinceEstivatorMapping() {
        super();
    }

    public List<ProvinceEstivatorDto> modelList(List<ProvinceEstivators> modelList) {
        return modelList.stream().map(item -> this.map(item, ProvinceEstivatorDto.class))
                .collect(Collectors.toList());
    }

    public ProvinceEstivators model(ProvinceEstivatorDto provinceEstivatorDto) {
        return this.map(provinceEstivatorDto, ProvinceEstivators.class);
    }

    public ProvinceEstivatorDto modelDto(ProvinceEstivators provinceEstivators) {
        return this.map(provinceEstivators, ProvinceEstivatorDto.class);
    }
}
