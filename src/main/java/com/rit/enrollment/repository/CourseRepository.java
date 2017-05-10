package com.rit.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

	@Query("select c from Course c, CourseStudent cs where cs.student.user.username=?1  and cs.course.courseId=c.courseId")
	List<Course> myCourses(String userName);

	@Query("select c from Course c, Classes cl where cl.faculty.user.username=?1  and cl.course.courseId=c.courseId")
	List<Course> myClasses(String userName);
	
	@Query("select c from Course c where c.department.user.username=?1")
	List<Course> allCoursesForDepartment(String userName);
}
