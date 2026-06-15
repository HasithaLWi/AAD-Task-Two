package lk.ijse.TaskTwo.service;

import lk.ijse.TaskTwo.dto.StudentDTO;

public interface StudentService {
    StudentDTO saveStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO);
    boolean deleteStudent(long id);
    StudentDTO searchStudent(String id);
}
