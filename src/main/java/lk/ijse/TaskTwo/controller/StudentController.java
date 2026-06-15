package lk.ijse.TaskTwo.controller;

import lk.ijse.TaskTwo.constant.CommonResponse;
import lk.ijse.TaskTwo.constant.ResponseCode;
import lk.ijse.TaskTwo.dto.StudentDTO;
import lk.ijse.TaskTwo.entity.Student;
import lk.ijse.TaskTwo.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent =  studentService.saveStudent(studentDTO);
        return new CommonResponse(ResponseCode.OPERATION_SUCCESS,savedStudent,"Student saved successfully");
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "update")
    public CommonResponse updateStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(studentDTO);
        return new CommonResponse(ResponseCode.OPERATION_SUCCESS, updatedStudent, "Student updated successfully");
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "delete/{id}")
    public CommonResponse deleteStudent(@PathVariable long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return new CommonResponse(ResponseCode.OPERATION_SUCCESS, "Student deleted successfully");
        } else {
            return new CommonResponse(ResponseCode.OPERATION_FAILED, "Failed to delete student");
        }
    }
}
