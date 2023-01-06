package pe.com.huex.security.service.resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.security.service.dto.MenuDto;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuListResponse {
    private List<MenuDto> menus = null;

    public MenuListResponse menu(List<MenuDto> menus) {
        this.menus = menus;
        return this;
    }
}
