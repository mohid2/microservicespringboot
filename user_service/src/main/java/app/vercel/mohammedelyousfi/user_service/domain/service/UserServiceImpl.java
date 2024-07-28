package app.vercel.mohammedelyousfi.user_service.domain.service;


import app.vercel.mohammedelyousfi.user_service.domain.dto.UserDTO;
import app.vercel.mohammedelyousfi.user_service.presistance.mapper.IUserMapper;
import app.vercel.mohammedelyousfi.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final IUserMapper userMapper;


    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        return userMapper.toUserDTO(userRepository.save(userMapper.toUserEntity(userDTO)));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return userMapper.toUserDTO(userRepository.save(userMapper.toUserEntity(userDTO)));
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.toUserDTO(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
