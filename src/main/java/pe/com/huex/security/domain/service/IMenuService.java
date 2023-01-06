package pe.com.huex.security.domain.service;

import pe.com.huex.security.service.resources.MenuListResponse;
import pe.com.huex.util.ResponseDto;

public interface IMenuService {

    ResponseDto<MenuListResponse> listMenus();

    ResponseDto<MenuListResponse> listMenusByIdUser( Long idUser);
}
