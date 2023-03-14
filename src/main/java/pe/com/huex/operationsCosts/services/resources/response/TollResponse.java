package pe.com.huex.operationsCosts.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.operationsCosts.services.resources.dto.TollDto;

@Data
@NoArgsConstructor
public class TollResponse {

    private TollDto tollDto=null;

    public TollResponse toll(TollDto tollDto){
        this.tollDto=tollDto;
        return this;
    }
}
