package com.cs590.miniproject.batch;

import com.cs590.miniproject.model.Student;
import com.cs590.miniproject.repository.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void write(List<? extends Student> students) throws Exception {
        System.out.println("Data saved for Student: "+students);
        studentRepository.saveAll(students);
    }
}
