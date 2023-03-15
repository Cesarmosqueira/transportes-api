package pe.com.huex.operationsCosts.services.resources.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import pe.com.huex.operationsCosts.services.resources.dto.RouteTollDto;

import java.util.List;

@Data
@NoArgsConstructor
public class RouteTollListResponse {

    private List<RouteTollDto> routeToll = null;

    public RouteTollListResponse routeToll(List<RouteTollDto> routeToll) {
        this.routeToll = routeToll;
        return this;
    }
}
