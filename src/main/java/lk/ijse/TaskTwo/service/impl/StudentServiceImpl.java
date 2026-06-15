package lk.ijse.TaskTwo.service.impl;

import lk.ijse.TaskTwo.dto.StudentDTO;
import lk.ijse.TaskTwo.entity.Section;
import lk.ijse.TaskTwo.entity.Student;
import lk.ijse.TaskTwo.enumaration.StudentStatus;
import lk.ijse.TaskTwo.repository.SectionRepository;
import lk.ijse.TaskTwo.repository.StudentRepository;
import lk.ijse.TaskTwo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private SectionRepository sectionRepository;

    public StudentServiceImpl(StudentRepository studentRepository, SectionRepository sectionRepository) {
        this.studentRepository = studentRepository;
        this.sectionRepository = sectionRepository;
    }
    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setStatus(StudentStatus.ACTIVE);

        Optional<Section> optionalSection = sectionRepository.findById(studentDTO.getSectionId());
        if (!optionalSection.isPresent()) {
            throw new RuntimeException("Section not found with id: " + studentDTO.getSectionId());
        }

        student.setSection(optionalSection.get());

        Student savedStudent = studentRepository.save(student);

        StudentDTO savedStudentDTO = new StudentDTO();
        savedStudentDTO.setId(savedStudent.getId());
        savedStudentDTO.setName(savedStudent.getName());
        savedStudentDTO.setAddress(savedStudent.getAddress());
        savedStudentDTO.setStatus(savedStudent.getStatus());
        savedStudentDTO.setSectionId(savedStudent.getSection().getId());

        return savedStudentDTO;

    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentRepository.findById(studentDTO.getId());
        if (!optionalStudent.isPresent()) {
            throw new RuntimeException("Student not found with id: " + studentDTO.getId());
        }

        Student student = optionalStudent.get();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setStatus(studentDTO.getStatus());
        Student updatedStudent = studentRepository.save(student);
        StudentDTO updatedStudentDTO = new StudentDTO();
        updatedStudentDTO.setId(updatedStudent.getId());
        updatedStudentDTO.setName(updatedStudent.getName());
        updatedStudentDTO.setAddress(updatedStudent.getAddress());
        updatedStudentDTO.setStatus(updatedStudent.getStatus());
        return updatedStudentDTO;



    }

    @Override
    public boolean deleteStudent(long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            throw new RuntimeException("Student not found with id: " + id);
        }

        Student student = optionalStudent.get();
        student.setStatus(StudentStatus.INACTIVE);
        studentRepository.save(student);

        return true;
    }

    @Override
    public StudentDTO searchStudent(String id) {
        return null;
    }
}
