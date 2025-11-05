package co.com.usersapi.api.mapper;

import co.com.usersapi.api.dto.request.UserRequestDTO;
import co.com.usersapi.api.dto.response.UserResponseDTO;
import co.com.usersapi.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponse(User user);


}
