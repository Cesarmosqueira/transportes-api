package pe.com.huex.security.service.dto;

import lombok.Getter;
import lombok.Setter;
import pe.com.huex.security.domain.entities.User;

@Setter
@Getter
public class UserMenuDto {
    private Long id;
    private UserDto user;
    private Long idParent;
    private Long idChild;
}
