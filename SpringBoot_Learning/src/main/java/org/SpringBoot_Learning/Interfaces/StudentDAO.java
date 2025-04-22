package org.SpringBoot_Learning.Interfaces;

import java.util.List;

import org.SpringBoot_Learning.Entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String last_name);

    void update(Student student);

    void deleteStudent(int id);

    int deleteAll();

}
