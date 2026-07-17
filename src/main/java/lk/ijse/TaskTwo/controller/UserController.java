package lk.ijse.TaskTwo.controller;

import lk.ijse.TaskTwo.constant.CommonResponse;
import lk.ijse.TaskTwo.dto.UserDTO;
import lk.ijse.TaskTwo.security.JwtUtil;
import lk.ijse.TaskTwo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public CommonResponse loginUser(UserDTO userDTO) {
        UserDTO UserDetails = userService.authenticateUser(userDTO);
        String token = jwtUtil.generateToken(UserDetails);
        return new CommonResponse(0, token, "JWT Token");
    }
}
