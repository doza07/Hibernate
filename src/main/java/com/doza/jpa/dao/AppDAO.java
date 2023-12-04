package com.doza.jpa.dao;


import com.doza.jpa.entity.Instructor;
import com.doza.jpa.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

     Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

     InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

}
