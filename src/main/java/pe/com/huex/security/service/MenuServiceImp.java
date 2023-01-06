package pe.com.huex.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.huex.security.domain.entities.Menu;
import pe.com.huex.security.domain.entities.UserMenu;
import pe.com.huex.security.domain.persistence.IMenuRepository;
import pe.com.huex.security.domain.persistence.IUserMenuRepository;
import pe.com.huex.security.domain.service.IMenuService;
import pe.com.huex.security.mapping.MenuMapping;
import pe.com.huex.security.service.dto.MenuDto;
import pe.com.huex.security.service.dto.UserMenuDto;
import pe.com.huex.security.service.resources.MenuListResponse;
import pe.com.huex.util.MetaDatosUtil;
import pe.com.huex.util.ResponseDto;

import java.util.*;
import java.util.stream.Collectors;

import static pe.com.huex.util.MensajeServicio.TipoEnum.INFO;
import static pe.com.huex.util.MensajeServicio.TipoEnum.WARN;

@Service
@Slf4j
public class MenuServiceImp implements IMenuService {

    private static final String MESSAGE_INQUIRY_MENU_SUCCESS = "La consulta del menu fue exitoso";
    private static final String MESSAGE_INQUIRY_MENU_WARN = "No se encontró ningún menu registrado";

    private static final String CODE_SUCCESS = "0";

    private static final String CODE_WARN = "1";

    @Autowired
    IMenuRepository menuRepository;

    @Autowired
    IUserMenuRepository userMenuRepository;

    @Autowired
    MenuMapping menuMapping;

    @Override
    public ResponseDto<MenuListResponse> listMenus() {
        ResponseDto<MenuListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<Menu> menuList = menuRepository.findAll();

            if (menuList.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_MENU_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_MENU_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(menuList.size()));
            response.setDatos(new MenuListResponse().menu(menuMapping.modelList(menuList)));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_MENU_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }

    @Override
    public ResponseDto<MenuListResponse> listMenusByIdUser(Long idUser) {
        ResponseDto<MenuListResponse> response = new ResponseDto<>();
        try {
            String idTransaccion = UUID.randomUUID().toString();

            List<UserMenu> userMenus = userMenuRepository.findByIdUser(idUser);

            if (userMenus.isEmpty()) {
                response.meta(MetaDatosUtil.buildMetadatos(CODE_WARN, MESSAGE_INQUIRY_MENU_WARN, WARN, idTransaccion)
                        .totalRegistros(0));
                return response;
            }

            List<MenuDto> menuList = new ArrayList<>();

            for (UserMenu userMenu : userMenus) {
                MenuDto menuDto = menuMapping.modelDto(menuRepository.findByIdParentAndIdChild(userMenu.getIdParent(), userMenu.getIdChild()));
                menuList.add(menuDto);
            }
            Map<Long, List<MenuDto>> studlistGrouped = menuList.stream().collect(Collectors.groupingBy(w -> w.getIdParent()));

            List<MenuDto> menuListResponse = new ArrayList<>();
            studlistGrouped.forEach((key, val) -> {
                Optional<MenuDto> menuDtoOptional = val.stream()
                        .filter(p -> p.getIdChild() == 0).findFirst();
                MenuDto menuDto = menuDtoOptional.get();
                var lista  = val.stream()
                        .filter(p -> p.getIdChild() != 0).collect(Collectors.toList());
                menuDto.setSubItems(lista);
                menuListResponse.add(menuDto);
            });

            response.meta(MetaDatosUtil.buildMetadatos(CODE_SUCCESS, MESSAGE_INQUIRY_MENU_SUCCESS, INFO, idTransaccion)
                    .totalRegistros(menuList.size()));
            response.setDatos(new MenuListResponse().menu(menuListResponse));

        } catch (Exception ex) {
            log.error(MESSAGE_INQUIRY_MENU_WARN + ": " + ex);
            throw ex;
        }

        return response;
    }
}
