package com.rit.enrollment.controllers;


import java.util.List;
import java.util.Locale;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rit.enrollment.logic.CoursesService;
import com.rit.enrollment.logic.UserService;
import com.rit.enrollment.repository.Course;
import com.rit.enrollment.repository.User;




/**
 * Handles requests for the application home page.
 */
@Controller
public class CoursesController {
	@Autowired
	private CoursesService coursesService;
	   
	private static final Logger logger = LoggerFactory.getLogger(CoursesController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/myf"}, method = RequestMethod.GET)
	public ModelAndView myCourses() {
		System.out.println("Entro en myCourses");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("myCourses");
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//List<Course> courses =  coursesService.myCourses(user.getUserId());
		//model.addAttribute("myCourses", courses);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/coursesList", method = RequestMethod.GET)
    public String coursesList(Model model) {
	 System.out.println("in CoursesList");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 /* List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "coursesList";*/
	 SimpleGrantedAuthority headSimpleGrantedAuthority = new SimpleGrantedAuthority("head");
	 SimpleGrantedAuthority studentSimpleGrantedAuthority = new SimpleGrantedAuthority("student");
	 SimpleGrantedAuthority facultySimpleGrantedAuthority = new SimpleGrantedAuthority("faculty");
	    if (user.getAuthorities().contains(headSimpleGrantedAuthority)){
	    	return "redirect:/myCoursesDepartment";
	    	
	    }else if (user.getAuthorities().contains(facultySimpleGrantedAuthority)){
	    	return "redirect:/myCoursesFaculty";
	    	
	    }else if (user.getAuthorities().contains(studentSimpleGrantedAuthority)){
	    	return "redirect:/myCoursesStudent";
	    	
	    }
	    
	    return null;
	}
	
	@RequestMapping(value = "/myCoursesDepartment", method = RequestMethod.GET)
    public String myCoursesDepartment(Model model) {
	 System.out.println("myCoursesDepartment");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "myCoursesDepartment";
	}
	
	@RequestMapping(value = "/myCoursesFaculty", method = RequestMethod.GET)
    public String myCoursesFaculty(Model model) {
	 System.out.println("myCoursesFaculty");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "myCoursesFaculty";
	}
	
	@RequestMapping(value = "/myCoursesStudent", method = RequestMethod.GET)
    public String myCoursesStudent(Model model) {
	 System.out.println("myCoursesStudent");
	 org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    List<Course> listCourses = this.coursesService.myCourses(user.getUsername(), user.getAuthorities());
		model.addAttribute("courses", listCourses);
		return "myCoursesStudent";
	}
	
	@RequestMapping(value = "/enrollStudent", method = RequestMethod.GET)
	public String enrollStudentd(Locale locale, Model model) {
		return "enrollStudent";
	}
	
}
