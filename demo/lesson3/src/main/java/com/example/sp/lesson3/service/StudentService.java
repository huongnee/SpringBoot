package com.example.sp.lesson3.service;

import com.example.sp.lesson3.entity.student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service class : StudentService
 * <p>Lớp dịch vụ thực hiện các chức năng thao tác với list object student<p>
 * @author Chung Trịnh
 * @version 1.0
 */


@Service
public class StudentService {
    //mock data
    List<student> students = new ArrayList<student>();
    public StudentService() {
        students.addAll(
                Arrays.asList(
                        new student(1L,"Dev,",10,"ok","ok","ok","ok","ok"),
                        new student(
                                2L,"Dev1,",10,"ok","ok","ok","ok","ok"
                        )
                )
        );
    }
    //Lấy toàn bộ danh sách sinh viên
    public List<student> getStudents() {
        return students;
    }
    //Lấy sinh viên theo id
    public student getStudent(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }
    //theem mới sv
    public student addStudent(student student) {
        students.add(student);
        return student;
    }
    //Cap nhat sv
    public student updateStudent(Long id ,student student) {
        student check = getStudent(id);
        if(check != null) {
            return null;
        }
        students.forEach(item->{
            if(item.getId() == id)
            {
                item.setName(student.getName());
                item.setAddress(student.getAddress());
                item.setEmail(student.getEmail());
                item.setPhone(student.getPhone());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
                item.setAddress(student.getAddress());
            }
                }
                );
        return student;
    }
    //xóa
    // Xóa thông tin sinh viene
    public boolean deleteStudent(Long id) {
        student student = getStudent(id);
        return students.remove(student);
    }
}
