package pe.com.huex.security.mapping;

import org.modelmapper.ModelMapper;
import pe.com.huex.security.domain.entities.Menu;
import pe.com.huex.security.service.dto.MenuDto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class MenuMapping extends ModelMapper implements Serializable {

    public MenuMapping() {
        super();
    }

    public List<MenuDto> modelList(List<Menu> modelList) {
        return modelList.stream().map(item -> this.map(item, MenuDto.class))
                .collect(Collectors.toList());
    }

    public Menu model(MenuDto menuDto) {
        return this.map(menuDto, Menu.class);
    }

    public MenuDto modelDto(Menu menuDto) {
        return this.map(menuDto, MenuDto.class);
    }
}
