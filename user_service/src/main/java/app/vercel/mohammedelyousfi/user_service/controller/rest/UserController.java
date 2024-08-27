package app.vercel.mohammedelyousfi.user_service.controller.rest;


import app.vercel.mohammedelyousfi.user_service.client.model.Booking;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserRequest;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserResponse;
import app.vercel.mohammedelyousfi.user_service.domain.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;


    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/create/one")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id,@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.updateUser(id,userRequest));
    }

    @GetMapping("/bookings/{userId}")
    public ResponseEntity<List<Booking>> getBookingByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getBookingByUserId(userId));
    }
}
