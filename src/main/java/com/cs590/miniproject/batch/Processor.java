package com.cs590.miniproject.batch;

import com.cs590.miniproject.model.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class Processor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        System.out.println("process ");
        int age = 2022 - student.getAge();
        student.setDob(new Date(age-1900,0,1));
        return student;
    }
}

