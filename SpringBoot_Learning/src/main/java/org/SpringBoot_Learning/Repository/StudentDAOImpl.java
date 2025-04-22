package org.SpringBoot_Learning.Repository;

import java.util.List;

import org.SpringBoot_Learning.Entity.Student;
import org.SpringBoot_Learning.Interfaces.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by last_name", Student.class);
        List<Student> students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findByLastName(String last_name) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where last_name = :lastName",
                Student.class);
        query.setParameter("lastName", last_name);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rows = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("Rows deleted: " + rows);
        return rows;
    }

}
