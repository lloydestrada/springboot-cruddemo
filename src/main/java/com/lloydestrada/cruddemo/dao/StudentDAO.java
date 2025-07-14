package com.lloydestrada.cruddemo.dao;

import com.lloydestrada.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
