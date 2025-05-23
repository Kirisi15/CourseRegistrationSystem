package com.example.Course.Registration.System.Controller;

import com.example.Course.Registration.System.Model.Course;
import com.example.Course.Registration.System.Model.CourseRegistry;
import com.example.Course.Registration.System.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/Courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/CoursesEnrolled")
    public List<Course> availableCourses(){
            return courseService.availableCourses();
    }



    @PostMapping("/register")
    public String enrollCourse(@RequestParam("name") String name,
                               @RequestParam("emailId") String emailId,
                               @RequestParam("courseName") String courseName) {
        courseService.enrollCourse(name,emailId,courseName);
                return "Successfully enrolled in the course: " + courseName;
    }

    @GetMapping("/Hi")
    public String home() {
        return "Welcome to the home page!";
    }

}
