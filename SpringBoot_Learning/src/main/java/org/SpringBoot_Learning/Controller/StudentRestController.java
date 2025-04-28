package org.SpringBoot_Learning.Controller;

import java.util.List;

import org.SpringBoot_Learning.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(
                new Student("John", "Doe"),
                new Student("Jane", "Doe"),
                new Student("Jim", "Beam"),
                new Student("Jack", "Daniels"),
                new Student("Johnny", "Walker"),
                new Student("James", "Bond"),
                new Student("Bruce", "Wayne"),
                new Student("Clark", "Kent"),
                new Student("Peter", "Parker"),
                new Student("Tony", "Stark"),
                new Student("Steve", "Rogers"),
                new Student("Natasha", "Romanoff"),
                new Student("Wade", "Wilson"),
                new Student("Thor", "Odinson"),
                new Student("Loki", "Laufeyson"),
                new Student("Diana", "Prince"),
                new Student("Barry", "Allen"),
                new Student("Hal", "Jordan"));
    }
}
