package com.doza.jpa;

import com.doza.jpa.dao.AppDAO;
import com.doza.jpa.entity.Course;
import com.doza.jpa.entity.Instructor;
import com.doza.jpa.entity.InstructorDetail;
import com.doza.jpa.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("DONE!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(course);

		System.out.println(course.getReviewList());

		System.out.println("DONE!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("TEST");

		course.addReview(new Review("Some review"));
		course.addReview(new Review("Bad review"));
		course.addReview(new Review("Good review"));

		System.out.println("Saving the course and reviews " + course + ", " + course.getReviewList());

		appDAO.save(course);

		System.out.println("DONE!");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int id = 11;

		System.out.println("Delete course: " + id);
		appDAO.deleteCourseById(id);

		System.out.println("DONE!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Find the course: " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course: " + id);
		course.setTitle("TEST");

		appDAO.update(course);

		System.out.println("DONE!");


	}

	private void updateInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Find instructor: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor: " + id);
		instructor.setLastName("TEST");

		appDAO.update(instructor);

		System.out.println("DONE");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 1;

		System.out.println("Find instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated course: " + tempInstructor.getCourseList());

		System.out.println("DONE!");


	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;
		System.out.println("Find instructor id: " + id);

		Instructor tempInstructor = appDAO.findInstructorById(id);

		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Finding for instructor id: " + id);

		List<Course> courseList = appDAO.findCoursesByInstructorId(id);

		tempInstructor.setCourseList(courseList);

		System.out.println("The associated course: " + tempInstructor.getCourseList());

		System.out.println("DONE!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor instructor =
				new Instructor("doza1", "doza1", "doza1@doza.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.doza1.com/youtube",
						"IT!!!");


		// associate the objects
		instructor.setInstructorDetail(tempInstructorDetail);

		Course course1 = new Course("C1");
		Course course2 = new Course("C2");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("saving instructor - " + instructor);
		System.out.println("The courses : " + instructor.getCourseList());
		appDAO.save(instructor);

		System.out.println("DONE!");
	}


	private void createInstructor(AppDAO appDAO) {


		// create the instructor
		Instructor instructor =
				new Instructor("doza", "doza", "doza@doza.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.doza.com/youtube",
						"IT!!!");


		// associate the objects
		instructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}

	private void findInstructorById(AppDAO appDAO) {

		int id = 3;

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor info: " + instructor.getInstructorDetail());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 1;

		appDAO.deleteInstructorById(theId);

		System.out.println("Instructor with id: " + theId + " success deleted" );
	}

	private void findInstructorDetailById(AppDAO appDAO) {

		int id = 2;

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor: " + instructorDetail);
		System.out.println("Instructor info: " + instructorDetail.getInstructor());
	}

	private void deleteInstructorDetailById(AppDAO appDAO) {
		int theId = 1;
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Instructor with id: " + theId + " success deleted" );
	}
}


