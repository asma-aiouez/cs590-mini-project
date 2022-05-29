package com.cs590.miniproject.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String first;
    private String last;
    private Double gpa;
    private Date Dob;
    @Transient
    private Integer age;

}
