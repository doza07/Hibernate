package com.doza.jpa.dao;


import com.doza.jpa.entity.Course;
import com.doza.jpa.entity.Instructor;
import com.doza.jpa.entity.InstructorDetail;
import com.doza.jpa.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

     Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

     InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    Course findCourseById(int id);

    void update(Course course);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student tempStudent);

    void deleteStudentById(int id);

}
