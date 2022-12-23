package pe.com.huex.security.service.resources;

import lombok.*;
import pe.com.huex.security.service.dto.UserDto;

import java.util.List;

@Data
@NoArgsConstructor
public class UserListResponse {
    private List<UserDto> users = null;

    public UserListResponse user(List<UserDto> users) {
        this.users = users;
        return this;
    }
}
