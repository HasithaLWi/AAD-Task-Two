package lk.ijse.TaskTwo.entity;

import jakarta.persistence.*;
import lk.ijse.TaskTwo.enumaration.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;
    private BookStatus status;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<Recode> recodes;
}
