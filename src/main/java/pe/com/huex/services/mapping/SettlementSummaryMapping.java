package pe.com.huex.services.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.services.domain.entities.SettlementSummary;
import pe.com.huex.services.service.resources.dto.SettlementSummaryDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class SettlementSummaryMapping extends ModelMapper implements Serializable {

    public SettlementSummaryMapping() {

        super();
    }

    public List<SettlementSummaryDto> modelList(List<SettlementSummary> modelList) {
        return modelList.stream().map(item -> this.map(item, SettlementSummaryDto.class))
                .collect(Collectors.toList());
    }

    public SettlementSummary model(SettlementSummaryDto settlementSummaryDto) {

        return this.map(settlementSummaryDto, SettlementSummary.class);
    }

    public SettlementSummaryDto modelDto(SettlementSummary settlementSummary) {

        return this.map(settlementSummary, SettlementSummaryDto.class);
    }
}
