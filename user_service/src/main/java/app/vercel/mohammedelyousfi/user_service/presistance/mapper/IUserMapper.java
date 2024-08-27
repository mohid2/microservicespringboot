package app.vercel.mohammedelyousfi.user_service.presistance.mapper;


import app.vercel.mohammedelyousfi.user_service.domain.model.UserRequest;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserResponse;
import app.vercel.mohammedelyousfi.user_service.presistance.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IUserMapper {

    User toUser(UserRequest userRequest);

    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponseList(List<User> users);

    List<User> toUserList(List<UserRequest> userRequests);
}
