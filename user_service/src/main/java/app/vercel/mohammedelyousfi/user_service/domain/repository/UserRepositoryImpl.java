package app.vercel.mohammedelyousfi.user_service.domain.repository;

import app.vercel.mohammedelyousfi.user_service.domain.exception.UserNotFoundException;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserRequest;
import app.vercel.mohammedelyousfi.user_service.domain.model.UserResponse;
import app.vercel.mohammedelyousfi.user_service.presistance.mapper.IUserMapper;
import app.vercel.mohammedelyousfi.user_service.presistance.repository.UserMysqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {


    private final UserMysqlRepository userMysqlRepository;
    private final IUserMapper userMapper;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        return userMapper.toUserResponse(userMysqlRepository.save(userMapper.toUser(userRequest)));
    }

    @Override
    public List<UserResponse> findAllUsers() {
        return userMapper.toUserResponseList(userMysqlRepository.findAll());
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        if (!userMysqlRepository.existsById(id)) {
            throw new UserNotFoundException("User not found");
        }
        userRequest.setId(id);
        return userMapper.toUserResponse(userMysqlRepository.save(userMapper.toUser(userRequest)));
    }

    @Override
    public UserResponse findUserById(Long id) {
        return userMapper.toUserResponse(userMysqlRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found")));
    }

    @Override
    public void deleteUser(Long id) {
        userMysqlRepository.deleteById(id);
    }
}
