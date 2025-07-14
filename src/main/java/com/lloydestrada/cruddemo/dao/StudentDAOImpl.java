package com.lloydestrada.cruddemo.dao;

import com.lloydestrada.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository //for component scanning
public class StudentDAOImpl implements StudentDAO{

    //define field
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //retrieving the id
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

}
