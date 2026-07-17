package lk.ijse.TaskTwo.service;

import lk.ijse.TaskTwo.dto.UserDTO;

public interface UserService {
    UserDTO authenticateUser(UserDTO userDTO);
    void registerUser(UserDTO userDTO);
}
