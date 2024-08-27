package app.vercel.mohammedelyousfi.user_service.domain.repository;


import app.vercel.mohammedelyousfi.user_service.domain.model.UserRequest;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserResponse;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository {
    UserResponse saveUser(UserRequest userRequest);
    List<UserResponse> findAllUsers();
    UserResponse updateUser(Long id,UserRequest userRequest);
    UserResponse findUserById(Long id);
    void deleteUser(Long id);
}
