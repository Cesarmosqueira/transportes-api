package pe.com.huex.providers.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.providers.domain.model.entity.TireReplacement;
import pe.com.huex.providers.service.resouces.dto.TireReplacementDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class TireReplacementMapping extends ModelMapper implements Serializable {

    public TireReplacementMapping() {
        super();
    }

    public List<TireReplacementDto> modelList(List<TireReplacement> modelList) {
        return modelList.stream().map(item -> this.map(item, TireReplacementDto.class))
                .collect(Collectors.toList());
    }

    public TireReplacement model(TireReplacementDto tireReplacementDto) {
        return this.map(tireReplacementDto, TireReplacement.class);
    }

    public TireReplacementDto modelDto(TireReplacement tireReplacement) {
        return this.map(tireReplacement, TireReplacementDto.class);
    }
}
