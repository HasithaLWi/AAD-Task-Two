package lk.ijse.TaskTwo.dto;

import lk.ijse.TaskTwo.enumaration.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private long id;
    private String name;
    private String address;
    private long sectionId;
    private StudentStatus status;

    public StudentDTO(String name, String address, long sectionId) {
        this.name = name;
        this.address = address;
        this.sectionId = sectionId;
    }
}
