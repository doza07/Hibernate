package com.doza.jpa;

import com.doza.jpa.dao.AppDAO;
import com.doza.jpa.entity.Instructor;
import com.doza.jpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

//		return runner -> {
//			createInstructor(appDAO);
//		};

//		return runner -> {
//			findInstructorById(appDAO);
//		};

//		return runner -> {
//			deleteInstructorById(appDAO);
//		};

//		return runner -> {
//			findInstructorDetailById(appDAO);
//		};

		return runner -> {
			deleteInstructorDetailById(appDAO);
		};
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
		int theId = 3;
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


