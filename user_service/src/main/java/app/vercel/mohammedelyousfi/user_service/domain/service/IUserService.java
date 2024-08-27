package app.vercel.mohammedelyousfi.user_service.domain.service;


import app.vercel.mohammedelyousfi.user_service.client.model.Booking;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserRequest;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserResponse;

import java.util.List;

public interface IUserService {
    UserResponse createUser(UserRequest userDTO);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Long id,UserRequest userDTO);
    UserResponse getUserById(Long id);
    void deleteUser(Long id);

    List<Booking> getBookingByUserId(Long id);
}
