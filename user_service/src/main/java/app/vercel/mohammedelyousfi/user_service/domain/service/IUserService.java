package app.vercel.mohammedelyousfi.user_service.domain.service;


import app.vercel.mohammedelyousfi.user_service.domain.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    void deleteUser(Long id);
}
