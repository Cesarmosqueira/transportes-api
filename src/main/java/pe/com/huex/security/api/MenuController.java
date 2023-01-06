package pe.com.huex.security.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.huex.security.domain.service.IMenuService;
import pe.com.huex.security.service.resources.MenuListResponse;
import pe.com.huex.util.ResponseDto;

@RestController
@RequestMapping(value = "security/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

    private final IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public ResponseDto<MenuListResponse> listMenus() {
        return menuService.listMenus();
    }

    @GetMapping("{idUser}")
    public ResponseDto<MenuListResponse> listMenusByIdUser(@PathVariable Long idUser) {
        return menuService.listMenusByIdUser(idUser);
    }
}