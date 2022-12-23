package pe.com.huex.security.service.resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import pe.com.huex.security.service.dto.UserDto;

@Data
@NoArgsConstructor
public class UserResponse {

    private UserDto user = null;

    public UserResponse user(UserDto userDto) {
        this.user = userDto;
        return this;
    }
}
