package pe.com.huex.security.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.huex.util.ResponseDto;
import pe.com.huex.security.domain.service.IUserService;
import pe.com.huex.security.service.dto.UserDto;
import pe.com.huex.security.service.resources.UserListResponse;
import pe.com.huex.security.service.resources.UserResponse;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "security/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseDto<UserListResponse> listUsers() {
        return userService.listUsers();
    }

    @GetMapping("{id}")
    public ResponseDto<UserResponse> retrieveUser(@PathVariable Long id) {
        return userService.retrieveUser(id);
    }

    @PostMapping
    public ResponseDto<UserResponse> registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

    @PutMapping
    public ResponseDto<UserResponse> updateUser(@RequestBody UserDto userDto) throws IOException {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("{id}")
    public ResponseDto<UserResponse> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
