package pe.com.huex.operationsCosts.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;

@Data
@NoArgsConstructor
public class RouteTollResponse {

    private RouteTollDto routeTollDto = null;

    public RouteTollResponse routeToll(RouteTollDto routeTollDto) {
        this.routeTollDto = routeTollDto;
        return this;
    }
}
