package app.vercel.mohammedelyousfi.user_service.domain.service.impl;


import app.vercel.mohammedelyousfi.user_service.client.BookingClient;
import app.vercel.mohammedelyousfi.user_service.client.model.Booking;
import app.vercel.mohammedelyousfi.user_service.domain.exception.UserNotFoundException;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserNotification;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserRequest;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserResponse;
import app.vercel.mohammedelyousfi.user_service.domain.repository.UserRepository;
import app.vercel.mohammedelyousfi.user_service.domain.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final BookingClient bookingClient;
    private final UserRepository userRepository;
    private final KafkaTemplate<String, UserNotification> kafkaTemplate;

    @Override
    @Transactional
    public UserResponse createUser(UserRequest userRequest) {
        UserResponse userResponse = userRepository.saveUser(userRequest);
        if (userResponse == null) {
            throw new UserNotFoundException("User not created");
        }

        Message<UserNotification> message = MessageBuilder.withPayload(UserNotification.builder()
                .userResponse(userResponse)
                .message("Usuario creado correctamente")
                .build())
                .setHeader(KafkaHeaders.TOPIC,"user-created")
                .build();
        kafkaTemplate.send(message);

        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id,UserRequest userRequest) {

        UserResponse userResponse = userRepository.saveUser(userRequest);
        if (userResponse == null) {
            throw new UserNotFoundException("User not updated");
        }
        Message<UserNotification> message = MessageBuilder.withPayload(UserNotification.builder()
                        .userResponse(userResponse)
                        .message("Usuario actualizado correctamente")
                        .build())
                .setHeader(KafkaHeaders.TOPIC,"user-created")
                .build();

        kafkaTemplate.send(message);
        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public List<Booking> getBookingByUserId(Long id) {
        return bookingClient.getBookingByUserId(id);
    }
}
