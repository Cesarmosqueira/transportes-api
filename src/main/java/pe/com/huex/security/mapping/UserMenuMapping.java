package pe.com.huex.security.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.security.domain.entities.UserMenu;
import pe.com.huex.security.service.dto.UserMenuDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class UserMenuMapping extends ModelMapper implements Serializable {

    public UserMenuMapping() {
        super();
    }

    public List<UserMenuDto> modelList(List<UserMenu> modelList) {
        return modelList.stream().map(item -> this.map(item, UserMenuDto.class))
                .collect(Collectors.toList());
    }

    public UserMenu model(UserMenuDto userMenuDto) {
        return this.map(userMenuDto, UserMenu.class);
    }

    public UserMenuDto modelDto(UserMenu userMenu) {
        return this.map(userMenu, UserMenuDto.class);
    }
}
