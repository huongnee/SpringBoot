package com.example.Lesson6.controller;

import com.example.Lesson6.dto.StudentDTO;
import com.example.Lesson6.entity.Student;
import com.example.Lesson6.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Display list of students
    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/student-list";
    }

    // Show form to add a new student
    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "students/student-add";
    }

    // Show form to edit a student by ID
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        StudentDTO student = studentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", student);
        return "students/student-edit";
    }

    // Save a new student
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentDTO student) {
        studentService.save(student);
        return "redirect:/students";
    }

    // Update an existing student by ID
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id,
                                @ModelAttribute("student") StudentDTO student) {
        studentService.updateStudentById(id, student);
        return "redirect:/students";
    }

    // Delete a student by ID
//    @GetMapping("/delete/{id}")
//    public String deleteStudent(@PathVariable(value = "id") Long id) {
//        studentService.deleteStudent(id);
//        return "redirect:/students";
//    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) {
        if (studentService.findById(id).isPresent()) {
            studentService.deleteStudent(id);
            return "redirect:/students";
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
    }

}
