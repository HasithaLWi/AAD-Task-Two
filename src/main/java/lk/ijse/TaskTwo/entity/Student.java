package lk.ijse.TaskTwo.entity;

import jakarta.persistence.*;
import lk.ijse.TaskTwo.enumaration.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    @Enumerated
    private StudentStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Section section;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Recode> recodes;
}
