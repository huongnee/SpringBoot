package com.example.Lesson6.service;


import com.example.Lesson6.dto.StudentDTO;
import com.example.Lesson6.entity.Student;
import com.example.Lesson6.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Find all students
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // Find student by ID and map to DTO
    public Optional<StudentDTO> findById(long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) return Optional.empty();

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setAge(student.getAge());

        return Optional.of(studentDTO);
    }

    // Save a new student from DTO
    public Boolean save(StudentDTO studentDTO) {
        try {
            Student student = new Student();
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.setAge(studentDTO.getAge());
            studentRepository.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Update an existing student by ID
    public Student updateStudentById(Long id, StudentDTO updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setAge(updatedStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }

    // Delete a student by ID
    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}