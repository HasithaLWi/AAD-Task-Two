package lk.ijse.TaskTwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowBookDTO {

    private long studentId;
    private long bookId;


}
