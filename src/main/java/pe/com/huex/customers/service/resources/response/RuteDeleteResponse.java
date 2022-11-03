package pe.com.huex.customers.service.resources.response;

import pe.com.huex.customers.service.resources.dto.RuteDto;

public class RuteDeleteResponse {

    private Long ruteId = null;

    public RuteDeleteResponse ruteDeleteResponse(Long ruteId) {
        this.ruteId = ruteId;
        return this;
    }
}
