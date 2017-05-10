package com.rit.enrollment.logic;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.rit.enrollment.repository.Course;
import com.rit.enrollment.repository.Student;
import com.rit.enrollment.repository.User;

public interface CoursesService {

	List<Course> myCourses(String username,  Collection<GrantedAuthority> authorities);

}
