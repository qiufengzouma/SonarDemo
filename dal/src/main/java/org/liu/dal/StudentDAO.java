package org.liu.dal;

import org.apache.ibatis.annotations.Mapper;
import org.liu.model.Student;

@Mapper
public interface StudentDAO {
    Student getStu(String id);
}
