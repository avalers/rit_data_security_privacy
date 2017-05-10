package config;

	import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
	import org.springframework.web.servlet.view.InternalResourceViewResolver;
	 
	@Configuration
	@ComponentScan(basePackages="com.rit.enrollment.controllers")
	public class MvcConfig extends WebMvcConfigurerAdapter{
	 
    
	     
	    @Bean
	 public InternalResourceViewResolver viewResolver() {
	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	  resolver.setPrefix("/WEB-INF/views/");
	  resolver.setSuffix(".jsp");
	  return resolver;
	 }  
	   @Override
	  public void addViewControllers(ViewControllerRegistry registry){
	    registry.addViewController("/login").setViewName("login");
	    registry.addViewController("/").setViewName("login");
	    registry.addViewController("main").setViewName("main");
	    registry.addViewController("myCoursesDepartment").setViewName("myCoursesDepartment");
	    registry.addViewController("myCoursesFaculty").setViewName("myCoursesFaculty");
	    registry.addViewController("myCoursesStudent").setViewName("myCoursesStudent");
	    }
	}
