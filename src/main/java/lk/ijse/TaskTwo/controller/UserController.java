package lk.ijse.TaskTwo.controller;

import lk.ijse.TaskTwo.constant.CommonResponse;
import lk.ijse.TaskTwo.dto.UserDTO;
import lk.ijse.TaskTwo.security.JwtUtil;
import lk.ijse.TaskTwo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/login")
    public CommonResponse loginUser(@RequestBody UserDTO userDTO) {
        UserDTO UserDetails = userService.authenticateUser(userDTO);
        String token = jwtUtil.generateToken(UserDetails);
        return new CommonResponse(0, token, "JWT Token");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/register")
    public CommonResponse registerUser(@RequestBody UserDTO userDTO) {
        userService.registerUser(userDTO);
        return new CommonResponse(0, null, "User registered successfully");
    }
}
