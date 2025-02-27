package com.example.sp.lesson3.controller;

import com.example.sp.lesson3.entity.student;
import com.example.sp.lesson3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * Lấy ds sv
     */
    @GetMapping("/student-list")
    public List<student> getAllStudents() {
        return studentService.getStudents();
    }

    /**
     * Lấy thông tin sinh viên theo id
     * @param: id
     */
    @GetMapping("/student/{id}")
    public student getStudentById(@PathVariable String id) {
        Long idStudent = Long.parseLong(id);
        return studentService.getStudent(idStudent);
    }

    /**
     * Thêm mới 1 sinh viên
     */
    @PostMapping("/student-add")
    public student addStudent(@RequestBody student student) {
        return studentService.addStudent(student);
    }

    /**
     * Sửa thông tin sinh viên
     */
    @PutMapping("/student/{id}")
    public student updateStudent(@PathVariable String id, @RequestBody student student) {
        Long idStudent = Long.parseLong(id);
        return studentService.updateStudent(idStudent, student);
    }
    /**
     * Xóa 1 sinh viên
     */
   @DeleteMapping("/student/{id}")
   public boolean deleteStudent(@PathVariable String id) {
       Long idStudent = Long.parseLong(id);
        return studentService.deleteStudent(idStudent);
   }
}
