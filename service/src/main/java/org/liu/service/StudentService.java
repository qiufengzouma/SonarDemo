package org.liu.service;

import org.liu.model.Student;
import org.liu.dal.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public Student getStu(String id) {
        return studentDAO.getStu(id);
    }
}
