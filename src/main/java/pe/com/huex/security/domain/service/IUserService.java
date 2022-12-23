package pe.com.huex.security.domain.service;

import pe.com.huex.util.ResponseDto;
import pe.com.huex.security.service.dto.UserDto;
import pe.com.huex.security.service.resources.UserListResponse;
import pe.com.huex.security.service.resources.UserResponse;

public interface IUserService {

    ResponseDto<UserListResponse> listUsers();

    ResponseDto<UserResponse> retrieveUser(Long id);

    ResponseDto<UserResponse> registerUser(UserDto userDto);

    ResponseDto<UserResponse> updateUser(UserDto userDto);

    ResponseDto deleteUser(Long id);
}
