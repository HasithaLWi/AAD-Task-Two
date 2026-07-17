package lk.ijse.TaskTwo.service.impl;

import lk.ijse.TaskTwo.dto.UserDTO;
import lk.ijse.TaskTwo.entity.User;
import lk.ijse.TaskTwo.repository.UserRepository;
import lk.ijse.TaskTwo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO authenticateUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findUserByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Sorry no user");
        }
        User user = optionalUser.get();
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getUserRole());
    }



    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public void registerUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setUserRole(userDTO.getUserRole());
        userRepository.save(user);
    }
}
