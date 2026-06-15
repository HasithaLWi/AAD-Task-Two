package lk.ijse.TaskTwo.dto;

import lk.ijse.TaskTwo.enumaration.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private long id;
    private String name;
    private String author;
    private BookStatus status;

    public BookDTO(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
