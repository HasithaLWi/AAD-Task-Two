package lk.ijse.TaskTwo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "recodes")
public class Recode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

}
