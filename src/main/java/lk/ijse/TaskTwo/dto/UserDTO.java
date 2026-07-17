package lk.ijse.TaskTwo.dto;


import lk.ijse.TaskTwo.enumaration.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private UserRoles userRole;

    public UserDTO(String username, String password, UserRoles userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
