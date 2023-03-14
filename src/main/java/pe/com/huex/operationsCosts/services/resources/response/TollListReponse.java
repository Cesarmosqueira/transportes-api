package pe.com.huex.operationsCosts.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.operationsCosts.services.resources.dto.TollDto;

import java.util.List;

@Data
@NoArgsConstructor
public class TollListReponse {

    private List<TollDto> tollDto=null;

    public  TollListReponse toll(List<TollDto> tollDto){
        this.tollDto=tollDto;
        return this;
    }

}
