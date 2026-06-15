package lk.ijse.TaskTwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SectionDTO {
    private long id;
    private String name;

    public SectionDTO(String name) {
        this.name = name;
    }
}
