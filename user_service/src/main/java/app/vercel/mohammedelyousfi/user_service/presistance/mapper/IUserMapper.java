package app.vercel.mohammedelyousfi.user_service.presistance.mapper;

import app.vercel.mohammedelyousfi.user_service.domain.dto.UserDTO;
import app.vercel.mohammedelyousfi.user_service.presistance.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {

    User toUserEntity(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOList(List<User> users);

    List<User> toUserList(List<UserDTO> userDTOS);
}
